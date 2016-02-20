package com.jxnu.webapp.service.impl;


import com.jxnu.webapp.dao.AdminDao;
import com.jxnu.webapp.model.Admin;
import com.jxnu.webapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zby on 16-1-20.
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

    @Autowired
    private AdminDao adminDao;

    public Admin loginByAdminnameAndPass(String loginName,String password) {
        Admin admin = new Admin();
        admin.setLoginName(loginName);
        admin.setPassword(password);
        return adminDao.selectByAdminNameAndPass(admin);
    }

}
