package com.potato.spring.framework;

import com.potato.spring.framework.beans.User;
import org.junit.Test;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;
import com.potato.spring.framework.beans.factory.support.DefaultListableBeanFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author potato
 * @date 2021/9/19 6:06 下午
 * @blame
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(User.class);
        beanFactory.registerBeanDefinition("user", beanDefinition);

        User user = (User) beanFactory.getBean("user", "potato");
        user.queryUser();
    }

    @Test
    public void test_newInstance() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?>[] constructors = User.class.getDeclaredConstructors();
        User user = (User) constructors[0].newInstance("");
        System.out.println(user);
    }

    @Test
    public void test_constructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        User user = User.class.getDeclaredConstructor(String.class).newInstance("patato");
        System.out.println(user);
    }
}
