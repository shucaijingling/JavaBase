package com.shucai.test;

import com.shucai.test.pojo.User;

import java.lang.reflect.Field;

public class TestForReflection{

        public static void main(String[] args) throws Exception {


                User user = new User("1", "zhangsan");

                String path = "com.shucai.test.pojo.User";

                Class<?> aClass = Class.forName(path);

                System.out.println(aClass);

                Field id = aClass.getDeclaredField("id");
                id.setAccessible(true);

                Object o = id.get(user);
                System.out.println(o);
                System.out.println((String) o);
        }
}
