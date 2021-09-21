package com.potato.spring.framework.beans.factory.config;

/**
 * @author potato
 * @date 2021/9/21 9:29 下午
 * @blame
 */
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
