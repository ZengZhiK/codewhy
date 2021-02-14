package com.zzk.codewhy.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zzk.codewhy.model.entity.DiscussPost;
import com.zzk.codewhy.model.vo.resp.DiscussPostRespVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 帖子表 Mapper 接口
 * </p>
 *
 * @author zzk
 * @since 2021-02-10
 */
public interface DiscussPostMapper extends BaseMapper<DiscussPost> {

    List<DiscussPostRespVo> selectVoList(@Param(Constants.WRAPPER) QueryWrapper<DiscussPostRespVo> queryWrapper);
}
