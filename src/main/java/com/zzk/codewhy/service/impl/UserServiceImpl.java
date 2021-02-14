package com.zzk.codewhy.service.impl;

import com.zzk.codewhy.model.entity.User;
import com.zzk.codewhy.mapper.UserMapper;
import com.zzk.codewhy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zzk
 * @since 2021-02-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
