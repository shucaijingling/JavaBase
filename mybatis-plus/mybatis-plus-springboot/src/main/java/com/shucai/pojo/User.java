package com.shucai.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter setter toString
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {


    @TableId(type = IdType.AUTO)
    private Long id;

//    @TableField(select = false)
    private String name;
    private Integer age;

    @TableField(value = "email")
    private String mail;

    @TableField(exist = false)
    private String address;

    private String userName;

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", email='" + email + '\'' +
//                '}';
//    }
}
