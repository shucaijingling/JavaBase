package com.xuyi.springframework.context.support;

import java.io.IOException;

public class ClasspathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClasspathXmlApplicationContext() {
    }

    public ClasspathXmlApplicationContext(String configLocations) throws IOException {
        this(new String[]{configLocations});
    }

    public ClasspathXmlApplicationContext(String[] configLocations) throws IOException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
