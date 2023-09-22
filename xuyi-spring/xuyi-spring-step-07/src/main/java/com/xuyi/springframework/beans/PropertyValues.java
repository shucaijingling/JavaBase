package com.xuyi.springframework.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {

    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }
}
