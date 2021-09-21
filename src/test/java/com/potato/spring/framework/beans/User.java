package com.potato.spring.framework.beans;

/**
 * @author potato
 * @date 2021/9/19 6:05 下午
 * @blame
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public void queryUser() {
        System.out.println(this);
    }
}
