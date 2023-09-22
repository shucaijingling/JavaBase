package com.xuyi.springframework.core.io;

import cn.hutool.core.lang.Assert;
import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.utils.ClassUtil;

import java.io.InputStream;

public class ClassPathResource implements Resource{

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "path must not be null");
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtil.getDefaultClassLoader() : classLoader;
    }

    @Override
    public InputStream getInputStream() {
        InputStream is = classLoader.getResourceAsStream(path);
        if (null == is) throw new BeansException("ClassPathResource  getInputStream failed ");
        return is;
    }
}
