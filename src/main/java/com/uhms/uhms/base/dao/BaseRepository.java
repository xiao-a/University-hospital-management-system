package com.uhms.uhms.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T,S> extends JpaRepository<T,S> {
}
