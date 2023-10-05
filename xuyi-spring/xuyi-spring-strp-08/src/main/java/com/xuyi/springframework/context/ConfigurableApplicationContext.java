package com.xuyi.springframework.context;

public interface ConfigurableApplicationContext extends ApplicationContext{

    void refresh();

    void registerShutDownHook();

    void close();
}
