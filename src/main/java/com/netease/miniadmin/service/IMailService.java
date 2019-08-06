package com.netease.miniadmin.service;

/**
 * @author dongxiyan
 * @date 2019-07-19 16:12
 */


import com.netease.miniadmin.common.entity.Email;

/**
 * 邮件发送服务
 *
 * @author wangdy
 * @date 2019/4/19 22:16
 */
public interface IMailService {

    /**
     * 纯文本发送
     *
     * @param mail
     */
    void send(Email mail);

}

