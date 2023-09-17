package com.xuyi.springframework.core.io;

/**
 * 包装资源加载器
 */
public interface ResourceLoader {

    String CLASSPATH_PREFIX = "classpath:";

    /**
     * 定义获取资源接口，传递 location 地址即可
     */
    Resource getResource(String location);
}
