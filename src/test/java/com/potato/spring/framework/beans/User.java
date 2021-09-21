package com.potato.spring.framework.beans;

/**
 * @author potato
 * @date 2021/9/19 6:05 下午
 * @blame
 */
public class User {

    private Integer uId;

    private UserDAO userDao;

    public void queryUserInfo() {
        System.out.println("queryUserInfo: " + userDao.queryUserName(uId));
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public UserDAO getUserDAO() {
        return userDao;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDao = userDAO;
    }
}
