package com.potato.spring.framework.aop;

/**
 * @author potato
 * @date 2021/9/29 10:02 下午
 * @blame
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
