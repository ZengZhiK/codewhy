package com.zzk.codewhy.controller;

import com.google.code.kaptcha.Producer;
import com.zzk.codewhy.common.annotation.LogPrint;
import com.zzk.codewhy.common.annotation.ModelView;
import com.zzk.codewhy.common.constant.Constants;
import com.zzk.codewhy.common.constant.SessionConstants;
import com.zzk.codewhy.common.exception.BusinessException;
import com.zzk.codewhy.common.exception.enums.BusinessExceptionType;
import com.zzk.codewhy.common.utils.AjaxResponse;
import com.zzk.codewhy.model.session.LoginTicket;
import com.zzk.codewhy.model.vo.req.LoginReqVo;
import com.zzk.codewhy.model.vo.req.RegisterReqVo;
import com.zzk.codewhy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 登录注册 前端控制器
 *
 * @author zzk
 * @create 2021-02-18 18:15
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private Producer kaptchaProducer;

    @LogPrint(description = "跳转至注册页面")
    @GetMapping("/register")
    @ModelView
    public String toRegister() {
        return "/site/register";
    }

    @LogPrint(description = "注册账号接口")
    @PostMapping("/register")
    @ResponseBody
    public AjaxResponse doRegister(@RequestBody @Valid RegisterReqVo vo) {
        userService.register(vo);
        return AjaxResponse.success();
    }

    @LogPrint(description = "激活账号接口")
    @GetMapping("/activation/{userId}/{code}")
    @ModelView
    public String doActivation(@PathVariable("userId") Integer userId,
                               @PathVariable("code") String code,
                               Model model) {
        int result = userService.activation(userId, code);
        if (result == Constants.ACTIVATION_SUCCESS) {
            model.addAttribute("msg", "激活成功,您的账号已经可以正常使用了!");
            model.addAttribute("target", "/login");
        } else if (result == Constants.ACTIVATION_REPEAT) {
            model.addAttribute("msg", "无效操作,该账号已经激活过了!");
            model.addAttribute("target", "/");
        } else {
            model.addAttribute("msg", "激活失败,您提供的激活码不正确!");
            model.addAttribute("target", "/");
        }
        return "/site/operate-result";
    }

    @LogPrint(description = "跳转至登录页面")
    @GetMapping(path = "/login")
    @ModelView
    public String getLoginPage() {
        return "/site/login";
    }

    @LogPrint(description = "刷新验证码图片")
    @GetMapping("/kaptcha")
    public void getKaptcha(HttpServletResponse response, HttpSession session) {
        // 生成验证码
        String text = kaptchaProducer.createText();
        BufferedImage image = kaptchaProducer.createImage(text);

        // 将验证码存入session
        session.setAttribute(SessionConstants.KAPTCHA, text.toLowerCase());

        // 将图片输出给浏览器
        response.setContentType("image/png");
        try {
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
            throw new BusinessException(BusinessExceptionType.VERIFICATION_CODE_ERROR);
        }
    }

    @LogPrint(description = "登录接口")
    @PostMapping("/login")
    @ResponseBody
    public AjaxResponse login(@RequestBody @Valid LoginReqVo loginReqVo, HttpSession session) {
        String verifycode = (String) session.getAttribute(SessionConstants.KAPTCHA);
        LoginTicket loginTicket = userService.login(loginReqVo, verifycode);
        session.setAttribute(SessionConstants.LOGIN_TICKET, loginTicket);
        return AjaxResponse.success();
    }

    @LogPrint(description = "登出接口")
    @GetMapping("/logout")
    @ModelView
    public String logout(HttpSession session) {
        session.invalidate();
        return "/site/login";
    }
}
