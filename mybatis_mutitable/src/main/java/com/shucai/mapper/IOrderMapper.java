package com.shucai.mapper;

import com.shucai.muti.pojo.Order;
import com.shucai.muti.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrderMapper {


    public List<Order> findOrderAndUser();

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "total", column = "total"),
            @Result(property = "user", column = "uid",javaType = User.class,
                    one=@One(select = "com.shucai.mapper.IUserMapper.findById"))
    })
    @Select("select * from orders")
    public List<Order> findOrderAndUser2();

    @Select("select * from orders where uid = #{id}")
    public List<Order> findOrder(Integer id);

}
