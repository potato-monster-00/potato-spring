package com.potato.spring.framework.context.support;

import com.potato.spring.framework.beans.factory.support.DefaultListableBeanFactory;
import com.potato.spring.framework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author potato
 * @date 2021/9/23 10:26 下午
 * @blame
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
