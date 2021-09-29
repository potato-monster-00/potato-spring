package com.potato.spring.framework.beans.factory.config;

import com.potato.spring.framework.beans.BeansException;

/**
 * @author potato
 * @date 2021/9/29 10:11 下午
 * @blame
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
