package com.potato.spring.framework;

import org.junit.Test;

/**
 * @author potato
 * @date 2021/9/18 10:12 下午
 * @blame
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 构建BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(new User());

        // 注册BeanDefinition
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBeanDefinition("user", beanDefinition);

        // 加载Bean
        User user = (User) beanFactory.getBean("user");
        user.queryUser();
    }
}
