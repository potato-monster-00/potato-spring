package com.potato.spring.framework.beans.factory.support;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author potato
 * @date 2021/9/19 1:57 下午
 * @blame
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibInstantiationStrategy();

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, name, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed.", e);
        }

        addSingleton(name, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String name, Object[] args) {
        Constructor<?> constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (args != null && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, name, constructorToUse, args);
    }
}
