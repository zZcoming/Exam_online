package com.jxnu.webapp.controller;

import com.jxnu.webapp.model.Admin;

import com.jxnu.webapp.util.NavigatorUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by zby on 16-1-20.
 * 后台主页控制器
 */
@Controller
@RequestMapping("/Admin")
public class AdminController {

    private static Logger log = Logger.getLogger(AdminController.class);

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView("Admin/Index/index");
        HttpSession session = request.getSession();
        if(session==null){
            NavigatorUtil.redirect(response,"loginUI.htm");
            return null;
        }
        Admin admin = (Admin)session.getAttribute("admin");
        modelAndView.addObject(admin);
        return modelAndView;
    }

    @RequestMapping("/welcome")
    public ModelAndView welcome(HttpServletRequest request){
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        log.info("welcome page "+admin.getLoginName());

        ModelAndView modelAndView = new ModelAndView("Admin/Index/welcome");
        modelAndView.addObject("admin",admin);

        return modelAndView;
    }
}
