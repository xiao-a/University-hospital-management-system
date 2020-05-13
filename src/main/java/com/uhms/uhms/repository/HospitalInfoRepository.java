package com.uhms.uhms.repository;

import com.uhms.uhms.entity.HospitalInfoEntity;
import com.uhms.uhms.entity.WatchListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalInfoRepository extends JpaRepository<HospitalInfoEntity,String> {
}
