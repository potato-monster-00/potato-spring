package com.potato.spring.framework.beans.factory.support;

import com.potato.spring.framework.beans.BeanException;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

/**
 * @author potato
 * @date 2021/9/19 1:57 下午
 * @blame
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeanException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new BeanException("Instantiation of bean failed.", e);
        }

        addSingleton(name, bean);
        return bean;
    }
}
