package com.xuyi.springframework.core.io;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASSPATH_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_PREFIX.length()));
        }else {
            try {
                return new UrlResource(new URL(location));
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
