package com.uhms.uhms.repository;

import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity,String> {
}
