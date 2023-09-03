package com.shucai.mybatisplusspringboot;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shucai.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAR {

    /**
     * 根据id查询
     */
    @Test
    public void testSelectById() {

        User user = new User();
        user.setId(10L);
        User result = user.selectById();
        System.out.println(result);
    }

    /**
     * 添加操作
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("蔬菜精灵");
        user.setAge(10);
        user.setMail("shucai@jingling.com");
        user.setAddress("上海浦东");
        user.setUserName("scjl");

        boolean b = user.insertOrUpdate();
        System.out.println(b ? "success" : "failed");
    }

    /**
     * 更新
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(2L);
        user.setName("shucai");
        user.setAge(110);
        user.setMail("22@1");
        user.setAddress("上海");
        user.setUserName("a");
        boolean b = user.updateById();
        System.out.println(b ? "success" : "failed");

    }

    /**
     * 删除
     */
    @Test
    public void testDelete() {
        User user = new User();
        user.setId(28L);
        boolean b = user.deleteById();
        System.out.println(b);
    }

    /**
     * 条件查询
     */
    @Test
    public void testSelectByCondition() {
        User user = new User();

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("age", 20);

        List<User> users = user.selectList(wrapper);
        for (User user1 : users) {

            System.out.println(user1);
        }
    }

    @Test
    public void optimistLock() {
        User user = new User();

        User selectById = user.selectById(27L);
        user.setName("蔬菜Lock");
        user.setAge(24);
        user.setId(selectById.getId());
        user.setVersion(selectById.getVersion());

        boolean insert = user.updateById();
        System.out.println(insert);
    }
}
