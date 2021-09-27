package com.potato.spring.framework.aop;

/**
 * @author potato
 * @date 2021/9/27 9:11 下午
 * @blame
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
