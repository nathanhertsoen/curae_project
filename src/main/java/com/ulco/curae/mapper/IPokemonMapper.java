package com.ulco.curae.mapper;

import com.ulco.curae.dto.PokemonDTO;
import com.ulco.curae.model.PokemonDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPokemonMapper {

    PokemonDTO toPokemonDTO(PokemonDO pokemonDO);
    PokemonDO toPokemonDO(PokemonDTO pokemonDTO);
}