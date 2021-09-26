package com.potato.spring.framework.beans.factory.config;

/**
 * @author potato
 * @date 2021/9/19 1:56 下午
 * @blame
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
