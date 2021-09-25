package com.potato.spring.framework.beans.factory;

/**
 * @author potato
 * @date 2021/9/25 8:53 下午
 * @blame
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);
}
