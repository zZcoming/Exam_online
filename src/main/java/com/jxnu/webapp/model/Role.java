package com.jxnu.webapp.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zby on 16-1-22.
 */
public class Role implements Serializable {

    private Integer id;
    private String name;
    private String menu_ids;

    private List<Menu> menus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenu_ids() {
        return menu_ids;
    }

    public void setMenu_ids(String menu_ids) {
        this.menu_ids = menu_ids;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
