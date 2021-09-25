package com.potato.spring.framework.beans.factory;

/**
 * @author potato
 * @date 2021/9/25 9:46 下午
 * @blame
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
