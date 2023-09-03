package com.shucai_0515.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Properties;

@SuppressWarnings({"all"})
public class Reflection01 {

    public static void main(String[] args) throws Exception{

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/com/shucai_0515/reflection/question/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();

        Class<?> cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
//        Field name = cls.getField("name");//不能获取私有属性

        Field age = cls.getField("age");
        //age.get(o)  反射获取属性值，  成员变量对象.get(对象)
        System.out.println(age.get(o));

        //获取构造器
        Constructor<?> constructor = cls.getConstructor();
        System.out.println(classfullpath);

        Constructor<?> constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);
    }
}
