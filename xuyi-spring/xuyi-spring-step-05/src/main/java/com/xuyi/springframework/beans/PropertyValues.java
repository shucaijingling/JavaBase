package com.xuyi.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性类，用于实例化后 对bean进行属性填充
 */
public class PropertyValues {

    private List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 添加属性
     */
    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    /**
     * 获取所有属性
     */
    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据属性名获取属性
     */
    public PropertyValue getPropertyValue(String name) {
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyValue.getName().equals(name)) {
                return propertyValue;
            }
        }
        return null;
    }
}
