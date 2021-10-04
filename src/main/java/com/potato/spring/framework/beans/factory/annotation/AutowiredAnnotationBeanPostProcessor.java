package com.potato.spring.framework.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.PropertyValues;
import com.potato.spring.framework.beans.factory.BeanFactory;
import com.potato.spring.framework.beans.factory.BeanFactoryAware;
import com.potato.spring.framework.beans.factory.ConfigurableListableBeanFactory;
import com.potato.spring.framework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.potato.spring.framework.util.ClassUtils;

import java.lang.reflect.Field;

/**
 * @author potato
 * @date 2021/10/4 11:00 上午
 * @blame
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxy(clazz) ? clazz.getSuperclass() : clazz;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            processValueAnnotation(bean, field);
            processAutowiredAnnotation(bean, field);
        }

        return pvs;
    }

    private void processValueAnnotation(Object bean, Field field) {
        Value valueAnnotation = field.getAnnotation(Value.class);
        if (valueAnnotation != null) {
            String value = valueAnnotation.value();
            value = beanFactory.resolveEmbeddedValue(value);
            BeanUtil.setFieldValue(bean, field.getName(), value);
        }
    }

    private void processAutowiredAnnotation(Object bean, Field field) {
        Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
        if (autowiredAnnotation != null) {
            Class<?> fieldType = field.getType();
            String dependentBeanName = null;
            Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
            Object dependentBean = null;
            if (qualifierAnnotation != null) {
                dependentBeanName = qualifierAnnotation.value();
                dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
            } else {
                dependentBean = beanFactory.getBean(fieldType);
            }
            BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }
}
