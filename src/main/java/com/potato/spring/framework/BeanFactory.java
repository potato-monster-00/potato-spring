package com.potato.spring.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author potato
 * @date 2021/9/18 10:04 下午
 * @blame
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

}
