package com.adder.admin.service.impl;

import com.adder.mapper.UserLogMapper;
import com.adder.pojo.UserLog;
import com.adder.service.IUserLogService;
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
public class UserLogServiceImpl extends ServiceImpl<UserLogMapper, UserLog> implements IUserLogService {

}
