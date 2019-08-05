package com.netease.miniadmin.controller;

import com.netease.miniadmin.model.SuperAdmin;
import com.netease.miniadmin.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private SuperAdminService superAdminService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index()
    {
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String hello()
    {
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session){
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        SuperAdmin admin = new SuperAdmin(userName,password);
        int temp = superAdminService.loginCheck(admin);
        if(temp == 1){
            session.setAttribute("admin",admin);
            return "redirect:/admin/user/index";
        }else{
            session.setAttribute("error_msg", "用户名或者密码错误！");
            return "redirect:/login";
        }
    }
}
