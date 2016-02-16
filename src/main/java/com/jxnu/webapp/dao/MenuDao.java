package com.jxnu.webapp.dao;

import com.jxnu.webapp.model.Menu;
import com.jxnu.webapp.rw.DataSource;

import java.util.List;

/**
 * Created by zby on 16-1-22.
 */
public interface MenuDao extends BaseDao<Menu>{

    @DataSource(isRead = true)
    List<Menu> listAllParentMenu();

    @DataSource(isRead = true)
    List<Menu> listSubMenuByParentId(Integer parentId);

    @DataSource(isRead = true)
    List<Menu> listAllSubMenu();

}
