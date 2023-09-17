package com.xuyi.springframework.context.support;

import com.xuyi.springframework.context.ConfigurableApplicationContext;
import com.xuyi.springframework.core.io.DefaultResourceLoader;

/**
 * 应用上下文抽象类实现
 */
public class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() {

    }
}
