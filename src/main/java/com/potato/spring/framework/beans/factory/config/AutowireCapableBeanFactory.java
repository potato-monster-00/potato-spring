package com.potato.spring.framework.beans.factory.config;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.factory.BeanFactory;

/**
 * @author potato
 * @date 2021/9/22 11:21 下午
 * @blame
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorBeforeInitialization(Object existBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorAfterInitialization(Object existBean, String beanName) throws BeansException;
}
