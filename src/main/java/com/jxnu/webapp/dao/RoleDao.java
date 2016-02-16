package com.jxnu.webapp.dao;

import com.jxnu.webapp.model.Role;
import com.jxnu.webapp.rw.DataSource;

import java.util.List;

/**
 * Created by zby on 16-1-22.
 */
public interface RoleDao {

    @DataSource(isRead = true)
    List<Role> listAllRoles();

    @DataSource(isRead = true)
    Role getRoleById(int id);

    void insertRole(Role role);

    void updateRoleBaseInfo(Role role);

    void deleteRoleById(int id);

    int getCountByName(Role role);

}
