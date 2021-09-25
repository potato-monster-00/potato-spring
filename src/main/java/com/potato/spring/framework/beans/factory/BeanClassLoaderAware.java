package com.potato.spring.framework.beans.factory;

/**
 * @author potato
 * @date 2021/9/25 8:51 下午
 * @blame
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);
}
