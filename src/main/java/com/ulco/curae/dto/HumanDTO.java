package com.ulco.curae.dto;

import com.ulco.curae.enums.HumanTypeEnum;
import com.ulco.curae.model.PokemonDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor // prends tous les apramètre de notre classe en entrée
@NoArgsConstructor // ajouter un constructeur par défaut

abstract class HumanDTO {

    @ApiModelProperty("id du patient")
    @Null(message ="L'id doit être vide à la création")
    protected Integer id;


    @ApiModelProperty("prénom du patient")
    @NotBlank(message = "Le patient a besoin d'un prénom")
    @Size(min = 1, max = 20, message ="la taille du prénom doit être comprise entre 1 et 20 caratères")
    protected String firstname;


    @ApiModelProperty("nom du patient")
    @NotBlank(message = "Le patient a besoin d'un nom de famille")
    @Size(min = 1, max = 20, message ="la taille du nom doit être comprise entre 1 et 20 caratères")
    protected String lastname;


    @ApiModelProperty("sexe du patient")
    @NotNull(message = "Vous devez choisir un des deux sexes : Homme / Femme")
    protected HumanTypeEnum humanType;


//    public PokemonDO toPokemonDO(){
//    PokemonDO pokemonDO = new PokemonDO();
//    pokemonDO.setId(id);
//    pokemonDO.setName(firstname);
//    pokemonDO.setTaille(taille);
//    pokemonDO.setPoids(poids);
//    pokemonDO.setPokemonType(pokemonType);
//
//    return pokemonDO;
//    }

}
