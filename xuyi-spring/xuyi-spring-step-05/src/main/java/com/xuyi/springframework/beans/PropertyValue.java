package com.xuyi.springframework.beans;

/**
 * 属性类定义，用于填充属性
 */
public class PropertyValue {

    /**
     * 属性名
     */
    private String name;

    /**
     * 属性值
     */
    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
