package com.potato.spring.framework.beans;

/**
 * @author potato
 * @date 2021/9/19 1:50 下午
 * @blame
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
