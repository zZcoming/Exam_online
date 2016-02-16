package com.jxnu.webapp.service.impl;

import com.jxnu.webapp.dao.MenuDao;
import com.jxnu.webapp.dao.RoleDao;
import com.jxnu.webapp.model.Menu;
import com.jxnu.webapp.model.Role;
import com.jxnu.webapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zby on 16-1-22.
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {



    public List<Role> listAllRoles() {
        List<Role> roles = roleDao.selectAll();
        for (Role role:roles){
            String[] menuList = role.getMenu_ids().split(",");
            for (int i = 0; i < menuList.length; i++) {
                List<Menu> menus = role.getMenus();
                menus.add(menuDao.queryById(Integer.valueOf(menuList[i])));
            }
        }
        return roles;
    }



    public boolean insertRole(Role role) {
        if (roleDao.getCountByName(role) > 0){
            return false;
        }else {
            roleDao.add(role);
            return true;
        }
    }

    public boolean updateRoleBaseInfo(Role role) {
        if(roleDao.getCountByName(role) > 0) {
            return false;
        }else {
            roleDao.update(role.getId());
            return true;
        }
    }

    public List<Role> listAllRolesAndMenu() {
        List<Role> roles = roleDao.selectAll();
        for (Role role : roles){
            //todo
        }
        return null;
    }
}
