package com.xuyi.springframework.context.support;

public class ClasspathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClasspathXmlApplicationContext() {
    }

    public ClasspathXmlApplicationContext(String configLocations) {
        this(new String[]{configLocations});
    }

    public ClasspathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
