package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.core.io.Resource;
import com.xuyi.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {

   BeanDefinitionRegistry getRegistry();

   ResourceLoader getResourceLoader();

   void loadBeanDefinitions(Resource resource);
   void loadBeanDefinitions(Resource... resources);

   void loadBeanDefinitions(String location);
   void loadBeanDefinitions(String... locations);
}
