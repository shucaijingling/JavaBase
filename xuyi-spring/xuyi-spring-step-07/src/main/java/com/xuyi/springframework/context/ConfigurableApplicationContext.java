package com.xuyi.springframework.context;

import java.io.IOException;

public interface ConfigurableApplicationContext extends ApplicationContext{

    void refresh() throws IOException;

    void registerShutdownHook();

    void close();
}
