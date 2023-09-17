package com.xuyi.springframework.core.io;


import com.xuyi.springframework.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClasspathResource implements Resource{


    private final String path;

    private ClassLoader classLoader;

    public ClasspathResource(String path) {
        this(path, null);
    }

    public ClasspathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (inputStream == null) throw new FileNotFoundException("[ClasspathResource getInputStream] failed : " + path);
        return inputStream;
    }
}
