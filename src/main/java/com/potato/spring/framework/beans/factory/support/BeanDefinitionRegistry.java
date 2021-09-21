package com.potato.spring.framework.beans.factory.support;

import com.potato.spring.framework.beans.factory.config.BeanDefinition;

/**
 * @author potato
 * @date 2021/9/19 1:55 下午
 * @blame
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
