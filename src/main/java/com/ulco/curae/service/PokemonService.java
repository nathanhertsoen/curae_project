//package com.ulco.curae.service;
//
//import com.ulco.curae.dto.PokemonDTO;
//import com.ulco.curae.enums.HumanTypeEnum;
//import com.ulco.curae.exception.AlreadyExistsException;
//import com.ulco.curae.exception.NotFoundException;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
////@Primary
//@Profile("production")
//@Service("PokemonServiceUsingLIST")
//public class PokemonService implements IPokemonService {
//
//    private final List<PokemonDTO> pokemonList;
//
//    public PokemonService() {
//        pokemonList = new ArrayList<>();
//
//        pokemonList.add(new PokemonDTO(1, "Charles II", 3.5, 3.5, HumanTypeEnum.H));
//        pokemonList.add(new PokemonDTO(2, "Intense Maurice", 3.5, 3.5, HumanTypeEnum.F));
//        pokemonList.add(new PokemonDTO(3, "Henri le plumé", 3.5, 3.5, HumanTypeEnum.H));
//    }
//
//
//    public void getProfil() {
//        log.info("Profil 'production' lancé");
//    }
//
//    @Override
//    public List<PokemonDTO> getAll() {
//        return pokemonList;
//    }
//
//
//    @Override
//    public PokemonDTO findById(Integer id) {
//        getProfil();
//        return pokemonList.stream()
//                .filter(pokemon -> pokemon.getId().equals(id))
//                .findFirst()
//                .orElseThrow(NotFoundException::new);
//    }
//
//
//    @Override
//    public void deleteAll() {
//        pokemonList.clear();
//    }
//
//
//    @Override
//    public void deleteById(Integer id) {
//        pokemonList.remove(findById(id));
//    }
//
//    @Override
//    public PokemonDTO save(PokemonDTO userDTO) {
//        int maxId = pokemonList.stream()
//                .map(PokemonDTO::getId)
//                .max(Comparator.naturalOrder())
//                .orElse(1);
//
//        userDTO.setId(maxId + 1);
//        pokemonList.add(userDTO);
//
//        return userDTO;
//    }
//
//
//    @ApiModelProperty("Methode native de la classe")
//    private void checkIdIsNotUsed(PokemonDTO findedPokemon, Optional<Integer> idOpt) {
//
//        boolean idAlreadyExists = pokemonList.stream()
//                .anyMatch(pokemon -> pokemon.getId().equals(findedPokemon.getId()));
//
//        if (idAlreadyExists && (!idOpt.isPresent() || !idOpt.get().equals(findedPokemon.getId()))) {
//            throw new AlreadyExistsException();
//        }
//    }
//
//
//    @Override
//    public void updateOne(PokemonDTO upgradedPokemon, Integer id) {
//
//        PokemonDTO pokemonToUpgrade = findById(id);
//        checkIdIsNotUsed(upgradedPokemon, Optional.of(id));
//
//        pokemonToUpgrade.setId(upgradedPokemon.getId());
//        pokemonToUpgrade.setName(upgradedPokemon.getName());
//        pokemonToUpgrade.setTaille(upgradedPokemon.getTaille());
//        pokemonToUpgrade.setPoids(upgradedPokemon.getPoids());
//        pokemonToUpgrade.setHumanType(upgradedPokemon.getHumanType());
//
//
//    }
//
//
////    @Override
////    public void createOne(PokemonDTO summonedPokemon) {
////
////        // METODE ALTERNATIVE
//////        try{
//////            findById(summonedPokemon.getId());
//////            throw  new AlreadyExistsException();
//////        } catch (NotFoundException e){
//////            pokemonList.add(summonedPokemon);
//////            return summonedPokemon;
//////        }
////
////
////
////        checkIdIsNotUsed(summonedPokemon, Optional.empty());
////        pokemonList.add(summonedPokemon);
////    }
//}
