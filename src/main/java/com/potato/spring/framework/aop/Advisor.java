package com.potato.spring.framework.aop;

import org.aopalliance.aop.Advice;

/**
 * @author potato
 * @date 2021/9/29 10:01 下午
 * @blame
 */
public interface Advisor {

    Advice getAdvice();
}
