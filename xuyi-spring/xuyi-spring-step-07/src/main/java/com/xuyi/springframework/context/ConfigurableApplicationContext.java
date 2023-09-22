package com.xuyi.springframework.context;

public interface ConfigurableApplicationContext extends ApplicationContext{

    void refresh();

    void registerShutdownHook();

    void close();
}
