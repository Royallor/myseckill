package com.adder.service.impl;

import com.adder.pojo.Admin;
import com.adder.mapper.AdminMapper;
import com.adder.service.IAdminService;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
