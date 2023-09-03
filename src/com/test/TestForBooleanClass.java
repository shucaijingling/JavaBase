package com.test;

import main.java.com.test.pojo.TestStreamVO;

import java.lang.reflect.Field;

public class TestForBooleanClass {

    public static void main(String[] args) {

        System.out.println(boolean.class);
        System.out.println(boolean.class.equals(TestStreamVO.class));

        TestStreamVO vo = new TestStreamVO();
        vo.setTestKey(11);



        try {
            Field testKey = vo.getClass().getDeclaredField("testKey");
            System.out.println(testKey);

            Field flag = vo.getClass().getDeclaredField("flag");
            Class<?> flagType = flag.getType();

            System.out.println("flag type is boolean : " + boolean.class.equals(flagType));
//            Object o = testKey.get(null);
//            System.out.println(o);

            Class<?> type = testKey.getType();
            System.out.println(type);

            System.out.println(boolean.class.equals(type));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
