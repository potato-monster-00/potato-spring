package com.potato.spring.framework.aop;

import cn.hutool.core.date.StopWatch;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * @author potato
 * @date 2021/9/27 9:42 下午
 * @blame
 */
public class UserServiceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("启动任务");
        try {
            return methodInvocation.proceed();
        } finally {
            System.out.println("monitor ----- aop");
            System.out.println("method name " + methodInvocation.getMethod());
            stopWatch.stop();
            System.out.println("cost " + stopWatch.prettyPrint());
            System.out.println("monitor ----- aop end");
        }
    }
}
