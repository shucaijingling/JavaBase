package com.shucai.inherit;

public class Handler {

    private ConfigurableEnvironment environment;

    public ConfigurableEnvironment getEnvironment() {
        if (this.environment == null) {
            return new DefaultConfigurableEnvironment();
        }
        return environment;
    }

    public void setEnvironment(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    public void testInherit() {
        String s = getEnvironment().resolvePlaceholders("Handler");
        System.out.println(s);
    }
}
