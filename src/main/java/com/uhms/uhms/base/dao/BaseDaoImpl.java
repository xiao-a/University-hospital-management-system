package com.uhms.uhms.base.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


public class BaseDaoImpl<T,S> implements BaseDao<T,S> {
    @Autowired
    private BaseRepository<T,S> baseRepository;
    @Override
    public void insert(T t) {
        baseRepository.save(t);
    }

    @Override
    public void deleteById(S s) {
        baseRepository.deleteById(s);
    }

    @Override
    public T getById(S s) {
        return baseRepository.getOne(s);
    }

    @Override
    public List<T> getAll() {
        return baseRepository.findAll();
    }

    @Override
    public void update(T t) {
        baseRepository.save(t);
    }
}
