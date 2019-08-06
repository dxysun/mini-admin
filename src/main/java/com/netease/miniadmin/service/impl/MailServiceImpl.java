package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.common.entity.Email;
import com.netease.miniadmin.service.IMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author dongxiyan
 * @date 2019-07-19 16:12
 */

@Service
public class MailServiceImpl implements IMailService {

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 邮件发送者
     */
    @Value("${spring.mail.username}")
    private String userName;

    //文本分割
    static {
        System.setProperty("mail.mime.splitlongparameters", "false");
    }

    @Override
    public void send(Email mail) {
        try {
            logger.info("发送普通文本邮件：{}", mail.getContent());
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(userName);
            message.setTo(mail.getEmail());
            message.setSubject(mail.getSubject());
            message.setText(mail.getContent());
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
