package com.shucai.mapper;

import com.shucai.muti.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserMapper {

    public List<User> findAll();

    public List<User> findUserAndRole();

    /**
     * 注解方式进行crud
     */
    @Insert("insert into user values (#{id}, #{username},null,null)")
    public void insert(User user);

    @Update("update user set username=#{username} where id = #{id}")
    public void update(User user);

    @Select("select * from user")
    public List<User> selectAll();

    @Delete("delete from user where id = #{id}")
    public void delete(Integer id);


    @Select("select * from user where id = #{id}")
    public User findById(Integer id);


    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "orderList", column = "id", javaType = List.class,
            many = @Many(select = "com.shucai.mapper.IOrderMapper.findOrder"))
    })
    public List<User> findAll2();
}
