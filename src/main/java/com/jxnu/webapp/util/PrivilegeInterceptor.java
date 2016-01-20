package com.jxnu.webapp.util;

import com.jxnu.webapp.model.Admin;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PrivilegeInterceptor extends HandlerInterceptorAdapter {

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
        System.out.println("拦截器回调执行");
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("调用controller后进入");
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {
        System.out.println("拦截器拦截开始：");

        Admin admin = (Admin)request.getSession().getAttribute("admin");

        // TODO 需要考虑到用户登录的是后台还是前台页面,后台页面需要登录验证,前台主页不需要验证
        if(admin == null){
            System.out.print("用户没有登录");
        }

        return true;
    }
}
