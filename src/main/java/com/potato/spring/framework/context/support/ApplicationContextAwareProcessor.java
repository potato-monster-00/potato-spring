package com.potato.spring.framework.context.support;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.factory.config.BeanPostProcessor;
import com.potato.spring.framework.context.ApplicationContext;
import com.potato.spring.framework.context.ApplicationContextAware;

/**
 * @author potato
 * @date 2021/9/25 8:55 下午
 * @blame
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware)bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
