package com.shucai.inherit;

public interface Environment extends PropertyResolver{

    boolean acceptsProfiles(String profiles);
}
