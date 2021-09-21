package com.potato.spring.framework.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * @author potato
 * @date 2021/9/21 9:38 下午
 * @blame
 */
public class UserDAO {

    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(10001, "p1");
        map.put(10002, "p2");
        map.put(10003, "p3");
    }

    public String queryUserName(Integer uId) {
        return map.get(uId);
    }
}
