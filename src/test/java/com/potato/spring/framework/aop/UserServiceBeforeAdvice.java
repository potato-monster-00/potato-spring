package com.potato.spring.framework.aop;

import java.lang.reflect.Method;

/**
 * @author potato
 * @date 2021/9/29 10:33 下午
 * @blame
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截：" + method.getName());
    }
}
