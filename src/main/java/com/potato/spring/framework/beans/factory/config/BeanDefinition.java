package com.potato.spring.framework.beans.factory.config;

/**
 * @author potato
 * @date 2021/9/19 1:53 下午
 * @blame
 */
public class BeanDefinition {

    private Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
