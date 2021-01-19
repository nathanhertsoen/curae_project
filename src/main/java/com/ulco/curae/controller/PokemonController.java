package com.ulco.curae.controller;

import com.ulco.curae.dto.PokemonDTO;
import com.ulco.curae.service.IPokemonService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    @ApiModelProperty("Powered by DHP Technology ©")

    @Autowired
    private IPokemonService pokemonService;

    @GetMapping
    @ApiOperation("Selectionner tous les pokemons.")
    public List<PokemonDTO> getAllPokemon() {
        return pokemonService.getAll();
    }


    @GetMapping("/{id}")
    @ApiOperation("Selectionner un pokemon.")
    public PokemonDTO getOnePokemon(@PathVariable Integer id) {
        return pokemonService.findById(id);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    @ApiOperation("Supprimer tous les pokemons.")
    public void sudoAptPurgePokemon() {
        pokemonService.deleteAll();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @ApiOperation("Supprimer un pokemon.")
    public void killXPokemon(
            @PathVariable Integer id) {
        pokemonService.deleteById(id);
    }


    @PostMapping
    @ApiOperation("Créer un pokemon.")
    public ResponseEntity<Void> save(@RequestBody final PokemonDTO pokemonDTO) {
        final PokemonDTO createdUser = pokemonService.save(pokemonDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Mettre à jour un pokemon.")
    public void update(@PathVariable final Integer id, @RequestBody @Valid final PokemonDTO pokemonDTO) {
        pokemonService.updateOne(pokemonDTO, id);
    }
}
