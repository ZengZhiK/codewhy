package com.zzk.codewhy.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzk.codewhy.common.constant.Constants;
import com.zzk.codewhy.common.exception.BusinessException;
import com.zzk.codewhy.common.exception.enums.BusinessExceptionType;
import com.zzk.codewhy.common.utils.MailClient;
import com.zzk.codewhy.mapper.UserMapper;
import com.zzk.codewhy.model.entity.User;
import com.zzk.codewhy.model.vo.req.RegisterReqVo;
import com.zzk.codewhy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zzk
 * @since 2021-02-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${codewhy.domain}")
    private String domain;

    @Override
    public void register(RegisterReqVo vo) {
        // 验证密码
        if (!vo.getPassword().equals(vo.getConfirmPassword())) {
            throw new BusinessException(BusinessExceptionType.CONFIRM_PASSWORD_ERROR);
        }

        // 验证账号
        User userInDb = userMapper.selectByUsername(vo.getUsername());
        if (userInDb != null) {
            throw new BusinessException(BusinessExceptionType.USERNAME_IS_REGISTERED_ERROR);
        }

        // 验证邮箱
        // TODO:和验证账号一样的逻辑...

        // 注册用户
        String salt = IdUtil.simpleUUID();
        String activationCode = IdUtil.simpleUUID();
        User user = new User();
        user.setUsername(vo.getUsername());
        user.setPassword(SecureUtil.md5(vo.getPassword() + salt));
        user.setSalt(salt);
        user.setEmail(vo.getEmail());
        user.setType(0);
        user.setStatus(0);
        user.setActivationCode(activationCode);
        user.setHeaderUrl(String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000)));
        user.setCreateTime(LocalDateTime.now());

        userMapper.insert(user);

        Context context = new Context();
        context.setVariable("email", user.getEmail());
        // http://localhost:8080/community/activation/101/code
        String url = domain + "/activation/" + user.getId() + "/" + user.getActivationCode();

        context.setVariable("url", url);
        String content = templateEngine.process("/mail/activation", context);
        mailClient.sendMail(user.getEmail(), "激活账号", content);
    }

    @Override
    public int activation(Integer userId, String code) {
        User user = userMapper.selectById(userId);
        if (user.getStatus() == 1) {
            return Constants.ACTIVATION_REPEAT;
        } else if (user.getActivationCode().equals(code)) {
            user.setStatus(1);
            userMapper.updateStatusById(user);
            return Constants.ACTIVATION_SUCCESS;
        }
        return Constants.ACTIVATION_FAILURE;

    }
}
