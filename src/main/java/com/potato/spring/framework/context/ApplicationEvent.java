package com.potato.spring.framework.context;

import java.util.EventObject;

/**
 * @author potato
 * @date 2021/9/26 9:25 下午
 * @blame
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
