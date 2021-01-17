package com.ulco.curae.repository;

import com.ulco.curae.model.HospitalizationDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHospitalizationRepository extends JpaRepository<HospitalizationDO, Integer> {
}
