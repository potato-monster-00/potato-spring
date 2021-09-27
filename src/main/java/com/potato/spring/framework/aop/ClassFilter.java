package com.potato.spring.framework.aop;

/**
 * @author potato
 * @date 2021/9/27 9:10 下午
 * @blame
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
