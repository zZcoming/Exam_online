package com.jxnu.webapp.service.impl;

import com.jxnu.webapp.dao.AdminDao;
import com.jxnu.webapp.dao.BaseDao;
import com.jxnu.webapp.dao.MenuDao;
import com.jxnu.webapp.dao.RoleDao;
import com.jxnu.webapp.model.Menu;
import com.jxnu.webapp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by zby on 16-2-17.
 */
public class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    AdminDao adminDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    MenuDao menuDao;

    private Class<T> clazz;

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public BaseServiceImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
        System.out.println(clazz.getSimpleName()); // Role
        System.out.println("clazz ---> " + clazz); // com.jxnu.webapp.Role
    }
    public void addEntity(T entity) {
        getDao().add(entity);
    }

    public T findById(Integer id) {
        return (T) getDao().queryById(id);
    }

    public void deleteById(Integer id) {
        getDao().delete(id);
    }

    public List<T> selectAll() {
        return getDao().selectAll();
    }
    public BaseDao getDao() {

        String className = this.getClazz().getSimpleName().toLowerCase();
        String daoName = className + "Dao"; // userDao

        if ("roleDao".equals(daoName)) {
            return roleDao;
        } else if ("menuDao".equals(daoName)) {
            return menuDao;
        } else if ("adminDao".equals(daoName)) {
            return adminDao;
        }else {
            return null;
        }

    }
}
