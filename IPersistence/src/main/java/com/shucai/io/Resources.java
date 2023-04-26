package com.shucai.io;

import java.io.InputStream;

public class Resources {

    //根据配置文件的路径，将配置文件加载成字节输入流，存储在内存中
    public static InputStream getResourcesAsStream(String path) {
        return Resources.class.getClassLoader().getResourceAsStream(path);

    }
}
