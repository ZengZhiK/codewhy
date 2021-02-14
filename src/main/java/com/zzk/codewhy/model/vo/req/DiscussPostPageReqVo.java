package com.zzk.codewhy.model.vo.req;

import lombok.Data;

/**
 * 帖子分页 请求VO
 *
 * @author zzk
 * @create 2021-02-14 11:05
 */
@Data
public class DiscussPostPageReqVo {
    /**
     * 当前页
     */
    private int pageNum = 1;

    /**
     * 每页的数量
     */
    private int pageSize = 10;
}
