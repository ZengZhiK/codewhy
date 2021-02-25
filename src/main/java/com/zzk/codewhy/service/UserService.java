package com.zzk.codewhy.service;

import com.zzk.codewhy.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzk.codewhy.model.vo.req.RegisterReqVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zzk
 * @since 2021-02-14
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param vo
     */
    void register(RegisterReqVo vo);
}
