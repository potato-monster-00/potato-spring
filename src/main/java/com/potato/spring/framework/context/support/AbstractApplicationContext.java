package com.potato.spring.framework.context.support;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.factory.ConfigurableListableBeanFactory;
import com.potato.spring.framework.beans.factory.config.BeanFactoryPostProcessor;
import com.potato.spring.framework.beans.factory.config.BeanPostProcessor;
import com.potato.spring.framework.context.ApplicationEvent;
import com.potato.spring.framework.context.ApplicationListener;
import com.potato.spring.framework.context.ConfigurableApplicationContext;
import com.potato.spring.framework.context.event.ApplicationEventMulticaster;
import com.potato.spring.framework.context.event.ContextClosedEvent;
import com.potato.spring.framework.context.event.ContextRefreshedEvent;
import com.potato.spring.framework.context.event.SimpleApplicationEventMulticaster;
import com.potato.spring.framework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * @author potato
 * @date 2021/9/23 10:25 下午
 * @blame
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVEN_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeansException {
        refreshBeanFactory();
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        invokeBeanFactoryPostProcessors(beanFactory);
        registerBeanPostProcessors(beanFactory);

        initApplicationEventMulticaster();
        registerListeners();

        beanFactory.preInstantiateSingletons();

        finishRefresh();
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        beanFactoryPostProcessorMap.values()
                .forEach(beanFactoryPostProcessor -> beanFactoryPostProcessor.postProcessBeanFactory(beanFactory));
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        beanPostProcessorMap.values()
                .forEach(beanFactory::addBeanPostProcessor);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(requiredType);
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVEN_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener<?> listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        publishEvent(new ContextClosedEvent(this));
        getBeanFactory().destroySingleBeans();
    }

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    protected abstract void refreshBeanFactory() throws BeansException;
}
