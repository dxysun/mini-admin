package com.netease.miniadmin.interceptor;

import com.netease.miniadmin.model.SuperAdmin;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor  {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SuperAdmin superAdmin = (SuperAdmin) request.getSession().getAttribute("admin");
        if(superAdmin == null)
        {
//            System.out.println("123");
            response.sendRedirect("/miniloveadmin/login");
            return false;
        }
        return true;
    }
}
