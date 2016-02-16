package com.jxnu.webapp.service;

import com.jxnu.webapp.model.Role;

import java.util.List;

/**
 * Created by zby on 16-1-22.
 */
public interface RoleService {

    List<Role> listAllRoles();
    Role getRoleById(int id);
    boolean insertRole(Role role);
    boolean updateRoleBaseInfo(Role role);
    void deleteRoleById(int id);
    List<Role> listAllRolesAndMenu();

}
