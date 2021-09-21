package com.potato.spring.framework.beans;

/**
 * @author potato
 * @date 2021/9/19 1:50 下午
 * @blame
 */
public class BeanException extends RuntimeException {

    public BeanException(String msg) {
        super(msg);
    }

    public BeanException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
