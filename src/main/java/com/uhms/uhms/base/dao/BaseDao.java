package com.uhms.uhms.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BaseDao<T,S>{
    void insert(T t);
    void deleteById(S s);
    T getById(S s);
    List<T> getAll();
    void update(T t);
}
