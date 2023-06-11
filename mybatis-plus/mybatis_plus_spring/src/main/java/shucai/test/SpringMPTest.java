package shucai.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import shucai.mapper.MPUserMapper;
import shucai.pojo.User;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringMPTest {

    @Autowired
    private MPUserMapper mapper;

    @Test
    public void test1() {

        List<User> users = mapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
