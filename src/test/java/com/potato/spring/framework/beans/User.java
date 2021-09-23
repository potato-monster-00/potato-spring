package com.potato.spring.framework.beans;

/**
 * @author potato
 * @date 2021/9/19 6:05 下午
 * @blame
 */
public class User {

    private Integer uId;
    private String company;
    private String location;
    private UserDAO userDao;

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
}
