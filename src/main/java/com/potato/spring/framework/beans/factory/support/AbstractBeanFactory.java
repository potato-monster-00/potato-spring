package com.potato.spring.framework.beans.factory.support;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.factory.BeanFactory;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;

/**
 * @author potato
 * @date 2021/9/19 1:56 下午
 * @blame
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return this.getBean(name, (Object) null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition, args);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;


}
