package com.potato.spring.framework.event;

import com.potato.spring.framework.context.ApplicationEvent;

/**
 * @author potato
 * @date 2021/9/26 10:20 下午
 * @blame
 */
public class CustomEvent extends ApplicationEvent {

    private Long id;
    private String message;

    public CustomEvent(Object source, Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
