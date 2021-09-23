package com.potato.spring.framework.context.support;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.factory.ConfigurableListableBeanFactory;
import com.potato.spring.framework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author potato
 * @date 2021/9/23 10:25 下午
 * @blame
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
