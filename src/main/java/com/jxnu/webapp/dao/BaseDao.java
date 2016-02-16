package com.jxnu.webapp.dao;

import com.jxnu.webapp.rw.DataSource;

import java.util.List;

/**
 * 基础组件,封装了DB的增删改查
 * Created by zby on 16-2-17.
 */
public interface BaseDao<T> {
    void add(T entity);

    void delete(Integer id);

    T update(Integer id);

    @DataSource(isRead = true)
    T queryById(Integer id);

    @DataSource(isRead = true)
    List<T> selectAll();
}
