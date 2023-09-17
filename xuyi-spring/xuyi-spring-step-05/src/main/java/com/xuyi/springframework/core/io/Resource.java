package com.xuyi.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源加载接口定义
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
