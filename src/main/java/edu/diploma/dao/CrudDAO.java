package edu.diploma.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDAO<T> {

    T find(Integer id);
    int save(T model);
    int update(T model);
    int delete(Integer id);

    List<T> findAll(int id);

}
