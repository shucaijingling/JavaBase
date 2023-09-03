package com.shucai_0515.reflection.question;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

@SuppressWarnings({"all"})
public class ReflectionQuestion {

    public static void main(String[] args) throws Exception{
        //根据配置文件  re.properties 指定信息， 创建Cat对象并调用方法hi

        //1.使用properties加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/com/shucai_0515/reflection/question/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();

        //2.根据全路径，实例化Cat，并且执行方法
        //类对象
        Class<?> cls = Class.forName(classfullpath);
        //方法对象
        Method declaredMethod = cls.getMethod(method);
        //创建实例
        Object o = cls.newInstance();
        //执行方法
        Object invoke = declaredMethod.invoke(o);

    }
}
