package com.shucai.inherit;

import java.util.Map;

public abstract class AbstractConfigurableEnvironment implements ConfigurableEnvironment {
    public AbstractConfigurableEnvironment() {
        System.out.println("AbstractConfigurableEnvironment");
    }

    protected void customizePropertySources(String propertySources) {
    }

    @Override
    public Map<String, Object> getSystemProperties() {
        return null;
    }

    @Override
    public boolean acceptsProfiles(String profiles) {
        return false;
    }

    @Override
    public String resolvePlaceholders(String text) {
        return text;
    }
}
