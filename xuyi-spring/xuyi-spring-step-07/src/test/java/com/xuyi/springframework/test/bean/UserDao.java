package com.xuyi.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> map = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行 init-method ");
        map.put("10001", "xuyi - 10001");
        map.put("10002", "xuyi - 10002");
        map.put("10003", "xuyi - 10003");
    }

    public void destroyDataMethod() {
        System.out.println("执行 destroy-method");
        map.clear();
    }

    public String queryUserName(String uId) {
        return map.get(uId);
    }
}
