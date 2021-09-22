package com.potato.spring.framework.beans.factory;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.factory.config.AutowireCapableBeanFactory;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;
import com.potato.spring.framework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author potato
 * @date 2021/9/22 11:20 下午
 * @blame
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
