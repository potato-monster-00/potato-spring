package com.potato.spring.framework.beans.factory;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.PropertyValue;
import com.potato.spring.framework.beans.PropertyValues;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;
import com.potato.spring.framework.beans.factory.config.BeanFactoryPostProcessor;
import com.potato.spring.framework.core.io.DefaultResourceLoader;
import com.potato.spring.framework.core.io.Resource;

import java.util.Properties;

/**
 * @author potato
 * @date 2021/9/30 11:00 下午
 * @blame
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    public final static String DEFAULT_PLACEHOLDER_PREFIX = "${";

    public final static String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) continue;
                    String strVal = (String) value;
                    StringBuilder buffer = new StringBuilder(strVal);
                    int startIndex = buffer.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int stopIndex = buffer.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (startIndex != -1 && stopIndex != -1 && startIndex < stopIndex) {
                        String propKey = strVal.substring(startIndex + 2, stopIndex);
                        String propVal = properties.getProperty(propKey);
                        buffer.replace(startIndex, stopIndex + 1, propVal);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), buffer.toString()));
                    }
                }
            }
        } catch (Exception e) {
            throw new BeansException("Could not load properties", e);
        }
    }
}
