package com.potato.spring.framework.context;

import com.potato.spring.framework.context.ApplicationEvent;

import java.util.EventListener;

/**
 * @author potato
 * @date 2021/9/26 9:32 下午
 * @blame
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
