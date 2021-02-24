package com.zzk.codewhy;

import cn.hutool.core.util.RandomUtil;
import com.zzk.codewhy.common.utils.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodewhyApplicationTests {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testMail() {
        mailClient.sendMail("buctzengzk@163.com", "TEST", "Hello World!");
    }

    @Test
    public void testMailHtml() {
        Context context = new Context();
        context.setVariable("username", "zzk");
        String content = templateEngine.process("/mail/activation", context);

        mailClient.sendMail("buctzengzk@163.com", "HTML", content);
    }

    @Test
    public void testUUID() {
    }
}
