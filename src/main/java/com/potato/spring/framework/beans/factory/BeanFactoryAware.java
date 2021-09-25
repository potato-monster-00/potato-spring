package com.potato.spring.framework.beans.factory;

import com.potato.spring.framework.beans.BeansException;

/**
 * @author potato
 * @date 2021/9/25 8:50 下午
 * @blame
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
