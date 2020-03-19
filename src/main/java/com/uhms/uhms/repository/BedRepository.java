package com.uhms.uhms.repository;

import com.uhms.uhms.entity.BedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<BedEntity,String> {
}
