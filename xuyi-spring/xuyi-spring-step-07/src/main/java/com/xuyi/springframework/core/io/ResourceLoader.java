package com.xuyi.springframework.core.io;

public interface ResourceLoader {

    String CLASSPATH_PREFIX = "classpath:";

    Resource getResource(String location);
}
