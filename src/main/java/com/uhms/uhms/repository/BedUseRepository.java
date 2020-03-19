package com.uhms.uhms.repository;

import com.uhms.uhms.entity.BedUseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedUseRepository extends JpaRepository<BedUseEntity,String> {
}
