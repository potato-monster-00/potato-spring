package com.potato.spring.framework.beans.factory;

import com.potato.spring.framework.beans.BeansException;

import java.util.Map;

/**
 * @author potato
 * @date 2021/9/22 11:17 下午
 * @blame
 */
public interface ListableBeanFactory extends BeanFactory {

    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    String[] getBeanDefinitionNames();
}
