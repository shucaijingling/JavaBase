package com.shucai.local.pojo;

import java.io.Serializable;

/**
 * @author 蔬菜精灵
 */
public class UserInfo implements Serializable {
    
    private int id;
    private String name;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
