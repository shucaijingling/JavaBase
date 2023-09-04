package com.shucai.mp.generator.user.service.impl;

import com.shucai.mp.generator.user.entity.User;
import com.shucai.mp.generator.user.mapper.UserMapper;
import com.shucai.mp.generator.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shucaijingling
 * @since 2023-09-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
