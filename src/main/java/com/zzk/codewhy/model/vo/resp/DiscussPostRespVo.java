package com.zzk.codewhy.model.vo.resp;

import com.zzk.codewhy.model.entity.DiscussPost;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zzk
 * @create 2021-02-14 14:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DiscussPostRespVo extends DiscussPost {
    /**
     * 发帖人用户名
     */
    private String username;

    /**
     * 发帖人头像url
     */
    private String headerUrl;
}
