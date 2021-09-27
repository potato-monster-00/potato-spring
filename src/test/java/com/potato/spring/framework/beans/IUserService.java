package com.potato.spring.framework.beans;

/**
 * @author potato
 * @date 2021/9/27 9:38 下午
 * @blame
 */
public interface IUserService {

    String queryUserInfo();

    String register(String userName);
}
