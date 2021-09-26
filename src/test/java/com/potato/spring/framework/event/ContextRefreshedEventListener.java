package com.potato.spring.framework.event;

import com.potato.spring.framework.context.ApplicationListener;
import com.potato.spring.framework.context.event.ContextRefreshedEvent;

/**
 * @author potato
 * @date 2021/9/26 10:26 下午
 * @blame
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("refresh event: " + this.getClass().getName());
    }
}
