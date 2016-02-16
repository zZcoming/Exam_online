package com.jxnu.webapp.service;

import com.jxnu.webapp.model.Admin;


import java.util.List;

/**
 * Created by zby on 16-1-20.
 */
public interface AdminService extends BaseService<Admin>{

    public Admin loginByAdminnameAndPass(String loginName, String password);

}
