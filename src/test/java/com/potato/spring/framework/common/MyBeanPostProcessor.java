package com.potato.spring.framework.common;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.User;
import com.potato.spring.framework.beans.factory.config.BeanPostProcessor;

/**
 * @author potato
 * @date 2021/9/23 11:18 下午
 * @blame
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("user".equals(beanName)) {
            User user = (User) bean;
            user.setLocation("chengdu");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
