package com.example.demo.dao;

import java.util.List;

public interface CrudDao<T, ID> {
    //Métodos generales que seran heredadas
    List<T> findAll();
    T findById(ID id);
    void save(T entity);
    void update(T entity);
    void deleteById(ID id);
}