package com.potato.spring.framework.beans;

import com.potato.spring.framework.beans.factory.*;
import com.potato.spring.framework.context.ApplicationContext;
import com.potato.spring.framework.context.ApplicationContextAware;

/**
 * @author potato
 * @date 2021/9/19 6:05 下午
 * @blame
 */
public class User implements InitializingBean, DisposableBean,
        BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, ApplicationContextAware {

    private Integer uId;
    private String company;
    private String location;
    private UserDAO userDao;

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public void queryUserInfo() {
        System.out.println("queryUserInfo: " + userDao.queryUserName(uId) + "," + company + "," + location);
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDAO getUserDAO() {
        return userDao;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDao = userDAO;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("User.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("User.destroy()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("classloader is: " + classLoader);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("bean name is : " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
