package shucai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import shucai.pojo.User;

import java.util.List;

public interface MPUserMapper extends BaseMapper<User> {

    List<User> finAll();
}
