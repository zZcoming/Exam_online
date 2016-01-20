package com.jxnu.webapp.service.impl;


import com.jxnu.webapp.dao.AdminDao;
import com.jxnu.webapp.model.Admin;
import com.jxnu.webapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zby on 16-1-20.
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    public void addAdmin(Admin admin) {
        adminDao.add(admin);
    }

    public List<Admin> findPage() {
        List<Admin> admins= adminDao.selectAll();
        return admins;
    }

    public Admin loginByAdminnameAndPass(String loginName,String password) {
        Admin admin = new Admin();
        admin.setLoginName(loginName);
        admin.setPassword(password);
        return adminDao.selectByAdminNameAndPass(admin);
    }
}
