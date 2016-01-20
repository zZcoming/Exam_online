package com.jxnu.webapp.dao;

import com.jxnu.webapp.model.Admin;
import com.jxnu.webapp.rw.DataSource;

import java.util.List;

/**
 * Created by zby on 16-1-20.
 */
public interface AdminDao {

    public void add(Admin admin);

    @DataSource(isRead = true)
    public List<Admin> selectAll();

    @DataSource(isRead = true)
    public Admin selectByAdminNameAndPass(Admin admin);

}
