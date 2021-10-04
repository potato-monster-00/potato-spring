package com.potato.spring.framework.beans;

import com.potato.spring.framework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author potato
 * @date 2021/9/21 9:38 下午
 * @blame
 */
@Component
public class UserDAO {

    public static Map<Integer, String> map = new HashMap<>();

    public String queryUserName(Integer uId) {
        return map.get(uId);
    }

    public void initDataMethod() {
        map.put(10001, "p1");
        map.put(10002, "p2");
        map.put(10003, "p3");
    }

    public void destroyDataMethod() {
        System.out.println("destroy method");
        map.clear();
    }
}
