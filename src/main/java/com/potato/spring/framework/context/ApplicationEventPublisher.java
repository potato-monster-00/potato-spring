package com.potato.spring.framework.context;

/**
 * @author potato
 * @date 2021/9/26 10:01 下午
 * @blame
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
