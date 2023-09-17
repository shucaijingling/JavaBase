package com.xuyi.springframework.context;

public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     */
   void refresh();
}
