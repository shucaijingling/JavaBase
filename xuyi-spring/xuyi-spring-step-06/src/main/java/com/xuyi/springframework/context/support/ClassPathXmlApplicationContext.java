package com.xuyi.springframework.context.support;

import java.io.IOException;

/**
 * 应用上下文实现类
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition， 并刷新上下文
     * @param configLocations
     * @throws IOException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws IOException {
        this(new String[]{configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition， 并刷新上下文
     * @param configLocations
     * @throws IOException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws IOException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
