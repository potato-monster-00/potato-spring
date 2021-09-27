package com.potato.spring.framework.beans;

import java.util.Random;

/**
 * @author potato
 * @date 2021/9/27 9:39 下午
 * @blame
 */
public class UserService implements IUserService {
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
}
