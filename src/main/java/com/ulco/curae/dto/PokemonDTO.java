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

public class PokemonDTO {

    @ApiModelProperty("l'id du pokemon")
    @Null(message ="L'id doit être vide à la création")
    private Integer id;


    @ApiModelProperty("nom du pokemon")
    @NotBlank(message = "Le pokemon a besoin d'un nom")
    @Size(min = 2, max = 10, message ="la taille du nom doit être comprise entre 2 et 10 caratères")
    private String name;


    @ApiModelProperty("taille du pokemon")
    @NotNull(message = "La taille ne peut pas être nulle")
    @Positive(message = "la valeur de taille doit être positive")
    private Double taille;


    @ApiModelProperty("poids du pokemon")
    @Positive(message = "Le poids ne peut pas être nulle")
    @NotNull(message = "Le poids doit avoir une valeur positive")
    private Double poids;


    @ApiModelProperty("type de pokemon")
//    @NotEmpty(groups = Default.class, message = "Le type doit être défini")
    @NotNull(message = "Vous devez saisir un des trois types suivants : FEU ; EAU ; PLANTE")
    private HumanTypeEnum pokemonType;


    public PokemonDO toPokemonDO(){
    PokemonDO pokemonDO = new PokemonDO();
    pokemonDO.setId(id);
    pokemonDO.setName(name);
    pokemonDO.setTaille(taille);
    pokemonDO.setPoids(poids);
    pokemonDO.setHumanType(pokemonType);

    return pokemonDO;
    }

}
