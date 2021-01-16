package com.ulco.curae.service;

import com.ulco.curae.dto.PokemonDTO;
import com.ulco.curae.exception.NotFoundException;
import com.ulco.curae.mapper.IPokemonMapper;
import com.ulco.curae.model.PokemonDO;
import com.ulco.curae.repository.IPokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
//@Primary
@Profile("development")
@Service("PokemonServiceUsingMAP")
public class PokemonServiceV2 implements IPokemonService {

    @Autowired
    private IPokemonMapper pokemonMapper;

    @Autowired
    private IPokemonRepository pokemonRepository;

    @Override
    public List<PokemonDTO> getAll() {
        return pokemonRepository.findAll().stream()
                .map(PokemonDO::toPokemonDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PokemonDTO findById(Integer id) {
        return pokemonRepository.findById(id)
                .map(PokemonDO::toPokemonDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public PokemonDTO save(PokemonDTO pokemonDTO) {


        final PokemonDO userToCreate = pokemonMapper.toPokemonDO(pokemonDTO);
        final PokemonDO createdUser = pokemonRepository.save(userToCreate);

        return pokemonMapper.toPokemonDTO(createdUser);

        //PokemonDO userDO = pokemonRepository.save(pokemonDTO.toPokemonDO());
        //return userDO.toPokemonDTO();
    }

    @Override
    public void deleteAll() {
        pokemonRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        pokemonRepository.deleteById(id);
    }

    @Override
    public void updateOne(PokemonDTO pokemonDTO, Integer id) {


            findById(id);
            PokemonDO pokemonToUpdate = pokemonMapper.toPokemonDO(pokemonDTO);
            pokemonToUpdate.setId(id);
            pokemonRepository.save(pokemonToUpdate);
    }
}
