package com.potato.spring.framework.beans.factory;

import com.potato.spring.framework.beans.BeansException;

/**
 * @author potato
 * @date 2021/9/19 1:54 下午
 * @blame
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
