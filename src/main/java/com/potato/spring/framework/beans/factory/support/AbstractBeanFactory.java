package com.potato.spring.framework.beans.factory.support;

import com.potato.spring.framework.beans.BeanException;
import com.potato.spring.framework.beans.factory.BeanFactory;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;

/**
 * @author potato
 * @date 2021/9/19 1:56 下午
 * @blame
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeanException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition) throws BeanException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;


}
