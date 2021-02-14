package com.zzk.codewhy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.zzk.codewhy.model.entity.DiscussPost;
import com.zzk.codewhy.model.vo.req.DiscussPostPageReqVo;
import com.zzk.codewhy.model.vo.resp.DiscussPostRespVo;

/**
 * <p>
 * 帖子表 服务类
 * </p>
 *
 * @author zzk
 * @since 2021-02-10
 */
public interface DiscussPostService extends IService<DiscussPost> {
    /**
     * 根据条件DiscussPostPageReqVO，分页查询帖子
     *
     * @param vo
     * @return
     */
    PageInfo<DiscussPostRespVo> pageInfo(DiscussPostPageReqVo vo);
}
