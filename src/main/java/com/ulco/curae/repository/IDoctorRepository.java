package com.ulco.curae.repository;

import com.ulco.curae.model.DoctorDO;
import com.ulco.curae.model.PokemonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<DoctorDO, Integer> {
}
