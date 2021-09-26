package com.potato.spring.framework.context.event;

import com.potato.spring.framework.context.ApplicationEvent;
import com.potato.spring.framework.context.ApplicationListener;

/**
 * @author potato
 * @date 2021/9/26 9:31 下午
 * @blame
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
