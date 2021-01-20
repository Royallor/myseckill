package com.adder.admin.service.impl;

import com.adder.mapper.UserMapper;
import com.adder.pojo.User;
import com.adder.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author adder
 * @since 2021-01-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
