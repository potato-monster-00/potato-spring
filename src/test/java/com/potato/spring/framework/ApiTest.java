package com.potato.spring.framework;

import cn.hutool.core.io.IoUtil;
import com.potato.spring.framework.aop.AdvisedSupport;
import com.potato.spring.framework.aop.TargetSource;
import com.potato.spring.framework.aop.UserServiceInterceptor;
import com.potato.spring.framework.aop.aspectj.AspectJExpressionPointcut;
import com.potato.spring.framework.aop.framework.Cglib2AopProxy;
import com.potato.spring.framework.aop.framework.JdkDynamicAopProxy;
import com.potato.spring.framework.beans.*;
import com.potato.spring.framework.beans.factory.config.BeanReference;
import com.potato.spring.framework.beans.factory.xml.XmlBeanDefinitionReader;
import com.potato.spring.framework.common.MyBeanFactoryPostProcessor;
import com.potato.spring.framework.common.MyBeanPostProcessor;
import com.potato.spring.framework.context.support.ClassPathXmlApplicationContext;
import com.potato.spring.framework.core.io.DefaultResourceLoader;
import com.potato.spring.framework.core.io.Resource;
import com.potato.spring.framework.event.CustomEvent;
import org.junit.Before;
import org.junit.Test;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;
import com.potato.spring.framework.beans.factory.support.DefaultListableBeanFactory;
import org.openjdk.jol.info.ClassLayout;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author potato
 * @date 2021/9/19 6:06 下午
 * @blame
 */
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.yml");
        InputStream in = resource.getInputStream();
        String content = IoUtil.readUtf8(in);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        User user = beanFactory.getBean("user", User.class);
        user.queryUserInfo();
    }

    @Test
    public void test_BeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();


        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDAO.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", 10001));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(User.class, propertyValues);
        beanFactory.registerBeanDefinition("user", beanDefinition);

        User user = (User) beanFactory.getBean("user");
        user.queryUserInfo();
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

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        User user = beanFactory.getBean("user", User.class);
        user.queryUserInfo();
    }

    @Test
    public void test_ClassPathXml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        User user = applicationContext.getBean("user", User.class);
        user.queryUserInfo();

        System.out.println("applicationContextAware: " + user.getApplicationContext());
        System.out.println("beanFactoryAware: " + user.getBeanFactory());
    }

    @Test
    public void test_prototype() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_proxy.xml");
        applicationContext.registerShutdownHook();

        User user1 = applicationContext.getBean("user", User.class);
        User user2 = applicationContext.getBean("user", User.class);

        System.out.println(user1);
        System.out.println(user2);

        System.out.println(user1 + "hex: " + Integer.toHexString(user1.hashCode()));
        System.out.println(ClassLayout.parseInstance(user1).toPrintable());
    }

    @Test
    public void test_factory_bean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_proxy.xml");
        applicationContext.registerShutdownHook();

        User user = applicationContext.getBean("user", User.class);
        user.queryUserInfo();
    }

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_event.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1234L, "success"));

        applicationContext.registerShutdownHook();
    }

    @Test
    public void test_dynamic() {
        IUserService userService = new UserService();
        AdvisedSupport advised = new AdvisedSupport();
        advised.setTargetSource(new TargetSource(userService));
        advised.setMethodInterceptor(new UserServiceInterceptor());
        advised.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.potato.spring.framework.beans.IUserService.*(..))"));

        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advised).getProxy();
        System.out.println("jdk proxy---- " + proxy_jdk.queryUserInfo());
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advised).getProxy();
        System.out.println("cglib proxy ---- " + proxy_cglib.register("potato"));
    }

    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_autoproxy.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        userService.queryUserInfo();
    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService);
    }

    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService);
    }

    @Test
    public void test_scan_annotation() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-annotation.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService.queryUserInfo());
    }

}
