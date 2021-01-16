package com.ulco.curae.repository;

import com.ulco.curae.model.PokemonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPokemonRepository extends JpaRepository<PokemonDO, Integer> {
}
