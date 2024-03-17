package edu.diploma.dao;

import java.util.List;

public interface CrudDAO<T> {

    T find(Integer id);

    int save(T model);

    int update(T model);

    int delete(Integer id);

    List<T> findAll(int id);

}
