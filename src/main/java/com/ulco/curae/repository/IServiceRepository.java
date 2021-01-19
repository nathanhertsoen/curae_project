package com.ulco.curae.repository;

import com.ulco.curae.dto.ServiceDTO;
import com.ulco.curae.model.HospitalizationDO;
import com.ulco.curae.model.ServiceDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceRepository extends JpaRepository<ServiceDO, Integer> {
    List<ServiceDTO> findByName(Integer id);
}
