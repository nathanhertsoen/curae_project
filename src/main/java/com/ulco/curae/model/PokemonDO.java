package com.ulco.curae.model;

import com.ulco.curae.dto.PokemonDTO;
import com.ulco.curae.enums.SexeTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pokemon")
public class PokemonDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "taille")
    private Double taille;

    @Column(name = "poids")
    private Double poids;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexe")
    private SexeTypeEnum sexe;


    @Transient
    public PokemonDTO toPokemonDTO() {
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(id);
        pokemonDTO.setName(name);
        pokemonDTO.setTaille(taille);
        pokemonDTO.setPoids(poids);
        pokemonDTO.setSexe(sexe);

        return pokemonDTO;
    }
}
