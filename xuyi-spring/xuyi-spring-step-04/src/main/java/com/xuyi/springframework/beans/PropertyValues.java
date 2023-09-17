package com.xuyi.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * bean 属性填充
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
     * 获取属性列表
     */
    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据属性名查询属性对象
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
