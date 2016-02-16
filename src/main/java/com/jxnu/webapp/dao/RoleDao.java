package com.jxnu.webapp.dao;

import com.jxnu.webapp.model.Role;
import com.jxnu.webapp.rw.DataSource;

import java.util.List;

/**
 * Created by zby on 16-1-22.
 */
public interface RoleDao extends BaseDao<Role>{

    int getCountByName(Role role);

}
