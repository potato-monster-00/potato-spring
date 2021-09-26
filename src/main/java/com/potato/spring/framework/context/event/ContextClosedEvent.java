package com.potato.spring.framework.context.event;

/**
 * @author potato
 * @date 2021/9/26 9:29 下午
 * @blame
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
