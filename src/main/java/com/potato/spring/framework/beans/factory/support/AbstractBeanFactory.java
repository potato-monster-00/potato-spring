package com.potato.spring.framework.beans.factory.support;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.factory.BeanFactory;
import com.potato.spring.framework.beans.factory.FactoryBean;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;
import com.potato.spring.framework.beans.factory.config.BeanPostProcessor;
import com.potato.spring.framework.beans.factory.config.ConfigurableBeanFactory;
import com.potato.spring.framework.util.ClassUtils;
import com.potato.spring.framework.util.StringValueResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author potato
 * @date 2021/9/19 1:56 下午
 * @blame
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private ClassLoader classLoader = ClassUtils.getDefaultClassLoader();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    @SuppressWarnings("unchecked")
    protected <T> T doGetBean(String name, Object[] args) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
        this.embeddedValueResolvers.add(valueResolver);
    }

    @Override
    public String resolveEmbeddedValue(String value) {
        String result = value;
        for (StringValueResolver resolver : this.embeddedValueResolvers) {
            result = resolver.resolveStringValue(result);
        }
        return result;
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.classLoader;
    }
}
