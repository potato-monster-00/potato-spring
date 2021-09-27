package com.potato.spring.framework.aop;

/**
 * @author potato
 * @date 2021/9/27 9:12 下午
 * @blame
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
