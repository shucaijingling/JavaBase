package com.xuyi.springframework.core.io;

/**
 * 资源加载类，爆装备
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 根据路径获取资源
     * @param location
     * @return
     */
    Resource getResource(String location);
}
