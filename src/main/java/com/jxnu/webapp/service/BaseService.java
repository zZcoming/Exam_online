package com.jxnu.webapp.service;

import java.util.List;

/**
 * Created by zby on 16-2-17.
 */
public interface BaseService<T> {
    void addEntity(T entity);

    T findById(Integer id);

    void deleteById(Integer id);

    List<T> selectAll();
}
