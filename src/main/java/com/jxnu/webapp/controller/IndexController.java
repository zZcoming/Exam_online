package com.jxnu.webapp.controller;


import com.jxnu.webapp.model.Admin;
import com.jxnu.webapp.service.AdminService;

import com.jxnu.webapp.util.NavigatorUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by zby on 16-1-20.
 * 登陆主页控制器
 */
@Controller
public class IndexController {

    private static Logger log = Logger.getLogger(IndexController.class);
    private static final String LOGINNAME= "loginName";
    private static final String PASSWORD = "password";

    @Autowired
    AdminService adminService;



    @RequestMapping("/loginUI")
    public ModelAndView loginUI() {
        return new ModelAndView("Admin/Login/loginUI");
    }

    @RequestMapping("/login")
    public void login(@RequestParam Map<String, String> data, HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        String loginName = data.get(LOGINNAME);
        String password = data.get(PASSWORD);

        log.info("User is try to Login backOffice! ");
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
            log.info("Illegal login!" + loginName + password);
            this.loginUI();
        }

        Admin admin = adminService.loginByAdminnameAndPass(loginName, password);
        if (admin==null) {
            NavigatorUtil.redirect(response, "loginUI.htm");
            return;
        }
        log.info(" user login success"+ loginName);
        // TODO 存储cookie
        HttpSession session = request.getSession();
        session.setAttribute("admin", admin);

        NavigatorUtil.redirect(response, "Admin/index.htm");
    }

    @RequestMapping("/logout")
    public void logout(@RequestParam Map<String, String> data, HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        // TODO 移除Cookie
        request.getSession().removeAttribute("admin");
        NavigatorUtil.redirect(response, "loginUI.htm");
    }
}
