package com.potato.spring.framework.beans.factory.config;

import com.potato.spring.framework.beans.BeansException;

/**
 * @author potato
 * @date 2021/9/23 10:22 下午
 * @blame
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
