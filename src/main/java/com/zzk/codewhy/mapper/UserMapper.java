package com.zzk.codewhy.mapper;

import com.zzk.codewhy.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zzk
 * @since 2021-02-14
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    User selectByUsername(String username);
}
