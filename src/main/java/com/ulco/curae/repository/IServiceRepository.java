package com.ulco.curae.repository;

import com.ulco.curae.model.ServiceDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<ServiceDO, Integer> {
}
