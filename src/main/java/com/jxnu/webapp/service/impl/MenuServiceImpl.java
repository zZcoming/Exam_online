package com.jxnu.webapp.service.impl;

import com.jxnu.webapp.dao.MenuDao;
import com.jxnu.webapp.model.Menu;
import com.jxnu.webapp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zby on 16-1-22.
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService{

    @Autowired
    private MenuDao menuDao;

    public List<Menu> listAllMenu() {
        List<Menu> menus = menuDao.listAllParentMenu();
        for (Menu menu : menus){
            List<Menu> subList = menuDao.listSubMenuByParentId(menu.getId());
            menu.setSubMenu(subList);
        }
        return menus;
    }

    public List<Menu> listAllParentMenu() {
        return menuDao.listAllParentMenu();
    }

    public List<Menu> listSubMenuByParentId(Integer parentId) {
        return menuDao.listSubMenuByParentId(parentId);
    }



    public void saveMenu(Menu menu) {
        if (menu.getId() != null && menu.getId().intValue() > 0) {
            menuDao.update(menu.getId());
        } else {
            menuDao.add(menu);
        }
    }



    public List<Menu> listAllSubMenu() {
        return menuDao.listAllSubMenu();
    }
}
