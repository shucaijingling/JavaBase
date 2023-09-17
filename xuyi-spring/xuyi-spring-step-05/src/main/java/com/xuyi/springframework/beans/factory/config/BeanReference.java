package com.xuyi.springframework.beans.factory.config;

/**
 * 依赖标记类：判断一个类中属性是否有其他引用
 */
public class BeanReference {

    private String name;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
