package com.potato.spring.framework.aop;

import java.lang.reflect.Method;

/**
 * @author potato
 * @date 2021/9/29 10:04 下午
 * @blame
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    void before(Method method, Object[] args, Object target) throws Throwable;
}
