package com.shucai.mapper;

import com.shucai.muti.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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


}
