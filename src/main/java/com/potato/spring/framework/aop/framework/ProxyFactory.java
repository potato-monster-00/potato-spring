package com.potato.spring.framework.aop.framework;

import com.potato.spring.framework.aop.AdvisedSupport;

/**
 * @author potato
 * @date 2021/9/29 10:28 下午
 * @blame
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createProxy().getProxy();
    }

    private AopProxy createProxy() {
        if (!advisedSupport.isProxyTargetClass()) {
            return new JdkDynamicAopProxy(advisedSupport);
        }

        return new Cglib2AopProxy(advisedSupport);
    }
}
