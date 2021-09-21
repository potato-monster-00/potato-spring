package com.potato.spring.framework;

/**
 * @author potato
 * @date 2021/9/18 10:03 下午
 * @blame
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return this.bean;
    }
}
