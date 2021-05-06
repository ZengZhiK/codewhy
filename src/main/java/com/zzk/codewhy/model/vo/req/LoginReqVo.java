package com.zzk.codewhy.model.vo.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 登录 请求VO
 *
 * @author zzk
 * @create 2021-05-06 10:41
 */
@Data
public class LoginReqVo {
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
     * 验证码
     */
    @Length(min = 4, max = 4, message = "请填写4位验证码")
    private String verifycode;

    /**
     * 记住我
     */
    private boolean rememberme;
}
