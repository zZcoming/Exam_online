package com.jxnu.webapp.service;

import com.jxnu.webapp.model.Role;

import java.util.List;

/**
 * Created by zby on 16-1-22.
 */
public interface RoleService extends BaseService<Role>{

    List<Role> listAllRoles();

    boolean insertRole(Role role);
    boolean updateRoleBaseInfo(Role role);

    List<Role> listAllRolesAndMenu();

}
