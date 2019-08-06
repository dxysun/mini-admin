package com.netease.miniadmin.config;

import com.netease.miniadmin.common.entity.Email;
import com.netease.miniadmin.service.IMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
/**
 * @author dongxiyan
 * @date 2019-07-19 16:12
 */


@ControllerAdvice
public class GlobalExceptionConfig {

    @Autowired
    private IMailService mailService;

    @Value("${spring.profiles.active}")
    private String springProfilesActive;

    private String[] email = {"310433562@qq.com"};

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionConfig.class);

    /**
     * 全局异常捕获
     *
     * @param request
     * @param req
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private String exceptionHandler(HttpServletRequest request, HttpServletRequest req, Exception e, Model model) {
        String ip = request.getRemoteAddr();
        InetAddress ia = null;
        String localName = "";
        try {
            ia = InetAddress.getLocalHost();
            localName = ia.getHostName();
        } catch (UnknownHostException e1) {
            logger.error(e1.getMessage(), e1);
        }
        String errorStr = "localhostname:" + localName + ",ip:" + ip + ",访问url:" + request.getRequestURI();
        if (!"dev".equals(springProfilesActive)) {
            Email mail = new Email();
            mail.setEmail(email);
            mail.setSubject("异常告警邮件通知");
            mail.setContent(errorStr + "\n" + getStackTrace(e));
            HashMap<String, Object> mapParam = new HashMap<>();
            mapParam.put("exceptionCause", e.getCause());
            mapParam.put("exceptionMessage", e.getMessage());
            mapParam.put("exceptionClass", e.getClass());
            mail.setKvMap(mapParam);
            //发送模板邮件
            mailService.send(mail);
        }
        logger.error(errorStr);
        logger.error(e.getMessage(), e);
        return errorStr + "\n" + e.getMessage() + "\n" + getStackTrace(e);
    }

    /**
     * 获取错误的堆栈信息
     *
     * @param throwable
     * @return
     */
    private String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            throwable.printStackTrace(printWriter);
            return stringWriter.toString();
        } finally {
            printWriter.close();
        }
    }
}
