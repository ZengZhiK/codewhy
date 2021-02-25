package com.zzk.codewhy.model.vo.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
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
    @Length(min = 5, max = 20, message = "密码长度必须位于5到20之间")
    private String password;

    /**
     * 确认密码
     */
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;

    /**
     * 邮箱
     */
    @Email(message = "请输入正确的邮箱")
    private String email;
}
