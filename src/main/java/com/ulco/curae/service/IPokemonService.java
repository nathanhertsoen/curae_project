package com.ulco.curae.service;

import com.ulco.curae.dto.PokemonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPokemonService {
    List<PokemonDTO> getAll();
    PokemonDTO findById(Integer id);


    PokemonDTO save(PokemonDTO pokemonDTO);


    void updateOne(PokemonDTO pokemonDTO, Integer id);

    void deleteById(Integer id);
    void deleteAll();

}
