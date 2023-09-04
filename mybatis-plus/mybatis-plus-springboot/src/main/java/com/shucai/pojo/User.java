package com.shucai.pojo;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter setter toString
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User extends Model<User> {


    @TableId(type = IdType.AUTO)
    private Long id;

//    @TableField(select = false)
    private String name;
    private Integer age;

    @TableField(value = "email")
    private String mail;

    @TableField(exist = false)
    private String address;

    @TableField(exist = false)
    private String userName;

    @Version
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer version;

    @TableLogic
    private Integer deleted;

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
