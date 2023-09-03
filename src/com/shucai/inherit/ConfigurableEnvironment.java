package com.shucai.inherit;

import java.util.Map;

public interface ConfigurableEnvironment extends Environment{



    Map<String, Object> getSystemProperties();
}
