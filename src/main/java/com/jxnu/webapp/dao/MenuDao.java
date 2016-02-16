package com.jxnu.webapp.dao;

import com.jxnu.webapp.model.Menu;
import com.jxnu.webapp.rw.DataSource;

import java.util.List;

/**
 * Created by zby on 16-1-22.
 */
public interface MenuDao {

    @DataSource(isRead = true)
    List<Menu> listAllParentMenu();

    @DataSource(isRead = true)
    List<Menu> listSubMenuByParentId(Integer parentId);

    @DataSource(isRead = true)
    Menu getMenuById(Integer id);

    void insertMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenuById(Integer id);

    @DataSource(isRead = true)
    List<Menu> listAllSubMenu();

}
