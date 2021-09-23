package com.potato.spring.framework.beans.factory.config;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author potato
 * @date 2021/9/23 10:22 下午
 * @blame
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
