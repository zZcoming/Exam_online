package com.jxnu.webapp.service;

import com.jxnu.webapp.model.Admin;


import java.util.List;

/**
 * Created by zby on 16-1-20.
 */
public interface AdminService {

    public void addAdmin(Admin admin);

    public List<Admin> findPage();

    public Admin loginByAdminnameAndPass(String loginName, String password);

}
