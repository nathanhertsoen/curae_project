package com.ulco.curae.controller;

import com.ulco.curae.dto.DoctorDTO;
import com.ulco.curae.service.IDoctorService;
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
@RequestMapping("/doctors")
public class DoctorController {
    @ApiModelProperty("Powered by Hertsoen Technology ©")

    @Autowired
    private IDoctorService doctorService;

    @GetMapping
    @ApiOperation("Selectionner tous les docteurs.")
    public List<DoctorDTO> getAll() {
        return doctorService.getAll();
    }


    @GetMapping("/{id}")
    @ApiOperation("Selectionner un docteur.")
    public DoctorDTO findById(@PathVariable Integer id) {
        return doctorService.findById(id);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    @ApiOperation("Supprimer tous les docteurs.")
    public void deleteAll() {
        doctorService.deleteAll();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @ApiOperation("Supprimer un docteur.")
    public void deleteById(
            @PathVariable Integer id) {
        doctorService.deleteById(id);
    }


    @PostMapping
    @ApiOperation("Créer un docteur.")
    public ResponseEntity<Void> save(@RequestBody final DoctorDTO doctorDTO) {
        final DoctorDTO createdDoctor = doctorService.save(doctorDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdDoctor.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Mettre à jour un docteur.")
    public void updateOne(@PathVariable final Integer id, @RequestBody @Valid final DoctorDTO doctorDTO) {
        doctorService.updateOne(doctorDTO, id);
    }
}
