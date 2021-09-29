package com.potato.spring.framework.aop.aspectj;

import com.potato.spring.framework.aop.Pointcut;
import com.potato.spring.framework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @author potato
 * @date 2021/9/29 10:15 下午
 * @blame
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    private Advice advice;

    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (pointcut == null) {
            return new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}
