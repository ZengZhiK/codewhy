package com.zzk.codewhy.controller;

import com.zzk.codewhy.common.annotation.LogPrint;
import com.zzk.codewhy.common.annotation.ModelView;
import com.zzk.codewhy.common.utils.AjaxResponse;
import com.zzk.codewhy.model.vo.req.RegisterReqVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 登录注册 前端控制器
 *
 * @author zzk
 * @create 2021-02-18 18:15
 */
@Controller
public class LoginController {
    @LogPrint(description = "跳转至注册页面")
    @GetMapping("/register")
    @ModelView
    public String toRegister() {
        return "/site/register";
    }

    @LogPrint(description = "注册接口")
    @PostMapping("/register")
    @ResponseBody
    public AjaxResponse doRegister(@RequestBody @Valid RegisterReqVo vo) {
        System.out.println(vo);
        return AjaxResponse.success();
    }
}
