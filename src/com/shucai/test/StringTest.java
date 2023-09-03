package com.shucai.test;

import com.shucai.test.pojo.User;

public class StringTest {
    public static void main(String[] args) {

        User user = new User();

        String s = "100" + user.getId() + "100";
        System.out.println(s);
    }
}
