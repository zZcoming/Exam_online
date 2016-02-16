package com.jxnu.webapp.controller;

import com.google.common.collect.Maps;

import com.jxnu.webapp.model.Admin;
import com.jxnu.webapp.model.Role;
import com.jxnu.webapp.service.AdminService;

import com.jxnu.webapp.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by zby on 16-1-20.
 * RBAC控制器
 */
@Controller
public class RbacController {

    private static Logger log = Logger.getLogger(RbacController.class);
    private static final String LOGINNAME= "loginName";
    private static final String PASSWORD = "password";
    private static final String ROLENAME = "name";

    @Autowired
    AdminService adminService;
    @Autowired
    RoleService roleService;

    @RequestMapping("/addAdminUI")
    public ModelAndView addAdminUI(){
        return new ModelAndView("Admin/AdminManage/addAdmin");
    }

    @RequestMapping("/addAdmin")
    @ResponseBody
    public ModelAndView addAdmin(@RequestParam Map<String, String> data, HttpServletRequest request) {
        Admin admin = new Admin();
        String loginName = data.get(LOGINNAME);
        String password = data.get(PASSWORD);
        admin.setLoginName(loginName);
        admin.setPassword(password);
        adminService.addAdmin(admin);
        return new ModelAndView("Admin/AdminManage/addAdminSuccess");
    }

    public void deleteAdmin(HttpServletRequest request){
        //根据前端id删除相关用户
    }

    public void editAdminUI(){

    }

    public void editAdmin(){

    }

    @RequestMapping("/adminListUI")
    public ModelAndView adminListUI(){
        return new ModelAndView("Admin/AdminManage/adminList");
    }

    @RequestMapping("/adminList")
    @ResponseBody
    public Map<String, Object> adminList(@RequestParam Map<String, String> data) {
        Map<String, Object> resultMap = Maps.newHashMap();
        List<Admin> lists = adminService.findPage();
        resultMap.put("rows", lists);
        resultMap.put("results", 1);
        return resultMap;
    }

    @RequestMapping("/addRoleUI")
    public ModelAndView addRoleUI(){
        return new ModelAndView("Admin/RoleManage/addRole");
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public ModelAndView addRole(@RequestParam Map<String, String> data, HttpServletRequest request){
        Role role = new Role();
        String name = data.get(ROLENAME);
        role.setName(name);
        if(role.getId()!= null && role.getId().intValue()>0){
            roleService.updateRoleBaseInfo(role);
        }else{
            roleService.insertRole(role);
        }
        return new ModelAndView("Admin/RoleManage/addRoleSuccess");
    }

    @RequestMapping("/roleListUI")
    public ModelAndView roleListUI(){
        return new ModelAndView("Admin/RoleManage/roleList");
    }

    @RequestMapping("/roleList")
    @ResponseBody
    public Map<String, Object> roleList(@RequestParam Map<String, String> data) {
        Map<String, Object> resultMap = Maps.newHashMap();
        List<Role> lists = roleService.listAllRoles();
        resultMap.put("rows", lists);
        resultMap.put("results", 1);
        return resultMap;
    }

}
