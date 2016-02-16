package com.jxnu.webapp.service;

import com.jxnu.webapp.model.Menu;

import java.util.List;

/**
 * Created by zby on 16-1-22.
 */
public interface MenuService {

    List<Menu> listAllMenu();
    List<Menu> listAllParentMenu();
    List<Menu> listSubMenuByParentId(Integer parentId);
    Menu getMenuById(Integer id);
    void saveMenu(Menu menu);
    void deleteMenuById(Integer id);
    List<Menu> listAllSubMenu();

}
