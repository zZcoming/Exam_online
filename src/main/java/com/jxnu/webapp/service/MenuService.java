package com.jxnu.webapp.service;

import com.jxnu.webapp.model.Menu;

import java.util.List;

/**
 * Created by zby on 16-1-22.
 */
public interface MenuService extends BaseService<Menu>{

    List<Menu> listAllMenu();
    List<Menu> listAllParentMenu();
    List<Menu> listSubMenuByParentId(Integer parentId);

    void saveMenu(Menu menu);

    List<Menu> listAllSubMenu();

}
