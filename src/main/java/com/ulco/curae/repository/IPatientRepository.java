package com.ulco.curae.repository;

import com.ulco.curae.model.PatientDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<PatientDO, Integer> {
}
