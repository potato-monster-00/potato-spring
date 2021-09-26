package com.potato.spring.framework.context.event;

import com.potato.spring.framework.context.ApplicationContext;
import com.potato.spring.framework.context.ApplicationEvent;

/**
 * @author potato
 * @date 2021/9/26 9:27 下午
 * @blame
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
