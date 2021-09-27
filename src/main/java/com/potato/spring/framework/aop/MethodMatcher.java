package com.potato.spring.framework.aop;

import java.lang.reflect.Method;

/**
 * @author potato
 * @date 2021/9/27 9:10 下午
 * @blame
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
