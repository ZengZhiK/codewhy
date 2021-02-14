package com.zzk.codewhy.controller;

import com.github.pagehelper.PageInfo;
import com.zzk.codewhy.common.annotation.LogPrint;
import com.zzk.codewhy.common.annotation.ModelView;
import com.zzk.codewhy.model.vo.req.DiscussPostPageReqVo;
import com.zzk.codewhy.model.vo.resp.DiscussPostRespVo;
import com.zzk.codewhy.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页 前端控制器
 *
 * @author zzk
 * @create 2021-02-14 10:59
 */
@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @LogPrint(description = "首页数据获取")
    @GetMapping({"/", "/index"})
    @ModelView
    public String getDiscussPostPageInfo(DiscussPostPageReqVo vo, Model model) {
        PageInfo<DiscussPostRespVo> pageInfo = discussPostService.pageInfo(vo);

        model.addAttribute("pageInfo", pageInfo);
        return "/index";
    }
}
