package com.potato.spring.framework.event;

import com.potato.spring.framework.context.ApplicationListener;

import java.time.LocalDateTime;

/**
 * @author potato
 * @date 2021/9/26 10:22 下午
 * @blame
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("receive: " + event.getSource() + ", time: " + LocalDateTime.now());
        System.out.println("message: " + event.getId() + ":" + event.getMessage());
    }
}
