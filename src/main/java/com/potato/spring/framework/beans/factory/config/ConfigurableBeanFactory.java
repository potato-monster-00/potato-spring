package com.potato.spring.framework.beans.factory.config;

import com.potato.spring.framework.beans.factory.HierarchicalBeanFactory;

/**
 * @author potato
 * @date 2021/9/22 11:22 下午
 * @blame
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
