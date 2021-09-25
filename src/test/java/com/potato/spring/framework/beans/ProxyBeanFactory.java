package com.potato.spring.framework.beans;

import com.potato.spring.framework.beans.factory.FactoryBean;
import com.potato.spring.framework.util.ClassUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author potato
 * @date 2021/9/25 10:09 下午
 * @blame
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {

    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = ((proxy, method, args) -> {
            Map<Integer, String> map = new HashMap<>();
            map.put(10001, "p1");
            map.put(10002, "p2");
            map.put(10003, "p3");

            return "proxy " + method.getName() + ": " + map.get(args[0]);
        });

        return (IUserDao) Proxy.newProxyInstance(ClassUtils.getDefaultClassLoader(), new Class[] {IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
