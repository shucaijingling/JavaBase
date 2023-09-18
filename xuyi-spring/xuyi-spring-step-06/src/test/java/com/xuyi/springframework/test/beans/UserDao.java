package com.xuyi.springframework.test.beans;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("10001","xuyi");
        map.put("10002","xuyi");
        map.put("10003","xuyi");
    }

    public String queryUserName(String uid) {
        return map.get(uid);
    }
}
