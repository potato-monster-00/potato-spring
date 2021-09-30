package com.potato.spring.framework.beans;

import com.potato.spring.framework.stereotype.Component;

import java.util.Random;

/**
 * @author potato
 * @date 2021/9/27 9:39 下午
 * @blame
 */
@Component("userService")
public class UserService implements IUserService {

    private String token;

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "potato";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "register " + userName + "success";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "token='" + token + '\'' +
                '}';
    }
}
