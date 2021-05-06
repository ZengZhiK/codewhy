package com.zzk.codewhy.model.session;

import lombok.Builder;
import lombok.Data;

/**
 * 用户登录信息，保存在 session 域
 *
 * @author zzk
 * @create 2021-05-06 16:42
 */
@Data
@Builder
public class LoginTicket {
    /**
     * 用户名
     */
    private String username;
}
