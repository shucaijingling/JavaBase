package com.xuyi.springframework.beans;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {

    private List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValues.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValues.toArray(new PropertyValue[0]);
    }

    //by name
    public PropertyValue getPropertyValue(String name) {
        for (PropertyValue propertyValue : this.propertyValues) {
            if (StrUtil.equals(name, propertyValue.getName())) {
                return propertyValue;
            }
        }
        return null;
    }
}
