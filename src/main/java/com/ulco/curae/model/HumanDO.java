package com.ulco.curae.model;

import com.ulco.curae.dto.PokemonDTO;
import com.ulco.curae.enums.HumanTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
abstract class HumanDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "firstname")
    protected String firstname;

    @Column(name = "lastname")
    protected String lastname;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexe")
    protected HumanTypeEnum humanType;


//    @Transient
//    public PokemonDTO toPokemonDTO() {
//        PokemonDTO pokemonDTO = new PokemonDTO();
//        pokemonDTO.setId(id);
//        pokemonDTO.setName(name);
//        pokemonDTO.setTaille(taille);
//        pokemonDTO.setPoids(poids);
//        pokemonDTO.setPokemonType(pokemonType);
//
//        return pokemonDTO;
//    }
}
