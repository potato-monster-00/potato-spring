package com.potato.spring.framework.context.event;

import com.potato.spring.framework.beans.factory.BeanFactory;
import com.potato.spring.framework.context.ApplicationEvent;
import com.potato.spring.framework.context.ApplicationListener;

/**
 * @author potato
 * @date 2021/9/26 10:06 下午
 * @blame
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener applicationListener : getApplicationListeners(event)) {
            applicationListener.onApplicationEvent(event);
        }
    }
}
