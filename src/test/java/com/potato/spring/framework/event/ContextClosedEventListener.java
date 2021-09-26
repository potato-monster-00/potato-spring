package com.potato.spring.framework.event;

import com.potato.spring.framework.context.ApplicationListener;
import com.potato.spring.framework.context.event.ContextClosedEvent;

/**
 * @author potato
 * @date 2021/9/26 10:25 下午
 * @blame
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("close event: " + this.getClass().getName());
    }
}
