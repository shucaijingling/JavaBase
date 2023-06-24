package com.shucai;

import com.shucai.mapper.UserMapper;
import com.shucai.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
@MapperScan("com.shucai.mapper")
public class MybatisPlusSpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication. run(MybatisPlusSpringbootApplication.class, args);
        UserMapper uerMapper = (UserMapper) context.getBean("userMapper");
        List<User> users = uerMapper.selectList(null);

    }

}
