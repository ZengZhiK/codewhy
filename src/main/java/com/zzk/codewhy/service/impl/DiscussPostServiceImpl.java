package com.zzk.codewhy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzk.codewhy.common.constant.Constants;
import com.zzk.codewhy.common.constant.TableConstants;
import com.zzk.codewhy.mapper.DiscussPostMapper;
import com.zzk.codewhy.mapper.UserMapper;
import com.zzk.codewhy.model.entity.DiscussPost;
import com.zzk.codewhy.model.entity.User;
import com.zzk.codewhy.model.vo.req.DiscussPostPageReqVo;
import com.zzk.codewhy.model.vo.resp.DiscussPostRespVo;
import com.zzk.codewhy.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 帖子表 服务实现类
 * </p>
 *
 * @author zzk
 * @since 2021-02-10
 */
@Service
public class DiscussPostServiceImpl extends ServiceImpl<DiscussPostMapper, DiscussPost> implements DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Override
    public PageInfo<DiscussPostRespVo> pageInfo(DiscussPostPageReqVo vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());

        QueryWrapper<DiscussPostRespVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc(TableConstants.GMT_CREATE);
        List<DiscussPostRespVo> discussPostRespVoList = discussPostMapper.selectVoList(queryWrapper);

        return new PageInfo<>(discussPostRespVoList, Constants.DEFAULT_NAVIGATE_PAGES);
    }
}
