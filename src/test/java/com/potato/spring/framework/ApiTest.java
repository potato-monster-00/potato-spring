package com.potato.spring.framework;

import com.potato.spring.framework.beans.User;
import org.junit.Test;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;
import com.potato.spring.framework.beans.factory.support.DefaultListableBeanFactory;

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

        User user = (User) beanFactory.getBean("user");
        user.queryUser();

        User singleUser = (User) beanFactory.getSingleton("user");
        singleUser.queryUser();
    }
}
