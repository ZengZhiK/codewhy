package com.zzk.codewhy.model.vo.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 注册请求VO
 *
 * @author zzk
 * @create 2021-02-24 22:39
 */
@Data
public class RegisterReqVo {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 确认密码
     */
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    private String email;
}
