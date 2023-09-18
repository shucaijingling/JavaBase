package com.xuyi.springframework.context;

import com.xuyi.springframework.beans.BeansException;

import java.io.IOException;

public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     */
   void refresh() throws IOException, BeansException;
}
