package com.xuyi.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("10001", "xuyi-10001");
        map.put("10002", "xuyi-10002");
        map.put("10003", "xuyi-10003");
    }

    public String queryUserName(String uId) {
        return map.get(uId);
    }
}
