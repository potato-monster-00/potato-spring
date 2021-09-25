package com.potato.spring.framework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.potato.spring.framework.beans.factory.DisposableBean;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @author potato
 * @date 2021/9/25 4:54 下午
 * @blame
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        if (StrUtil.isNotEmpty(destroyMethodName) &&
                !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            destroyMethod.invoke(bean);
        }
    }
}
