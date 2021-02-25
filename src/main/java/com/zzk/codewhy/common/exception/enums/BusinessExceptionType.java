package com.zzk.codewhy.common.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 自定义异常信息
 *
 * @author zzk
 * @create 2020-12-22 8:50
 */
@AllArgsConstructor
@Getter
public enum BusinessExceptionType {
    SUCCESS(200, "成功！"),
    USER_INPUT_ERROR(400, "您输入的数据错误!"),
    CONFIRM_PASSWORD_ERROR(400, "两次输入的密码不一致!"),
    USERNAME_IS_REGISTERED_ERROR(400, "该用户名已经被注册！"),
    SYSTEM_ERROR(500, "系统出现异常，请您稍后再试或联系管理员！");

    /**
     * 异常编码
     */
    private final int code;

    /**
     * 异常信息
     */
    private final String msg;
}
