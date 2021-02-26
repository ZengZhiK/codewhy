package com.zzk.codewhy.model.vo.req;

import com.zzk.codewhy.common.constant.Constants;
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
    private int pageNum = Constants.DEFAULT_PAGE_NUM;

    /**
     * 每页的数量
     */
    private int pageSize = Constants.DEFAULT_PAGE_SIZE;
}
