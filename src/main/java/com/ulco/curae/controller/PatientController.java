package com.ulco.curae.controller;

import com.ulco.curae.dto.PatientDTO;
import com.ulco.curae.service.IPatientService;
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
@RequestMapping("/patients")
public class PatientController {
    @ApiModelProperty("Powered by DHP Technology ©")

    @Autowired
    private IPatientService patientService;

    @GetMapping
    @ApiOperation("Selectionner tous les patients.")
    public List<PatientDTO> getAll() {
        return patientService.getAll();
    }


    @GetMapping("/{id}")
    @ApiOperation("Selectionner un patient.")
    public PatientDTO findById(@PathVariable Integer id) {
        return patientService.findById(id);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    @ApiOperation("Supprimer tous les patients.")
    public void deleteAll() {
        patientService.deleteAll();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @ApiOperation("Supprimer un patient.")
    public void deleteById(@PathVariable Integer id) {
        patientService.deleteById(id);
    }


    @PostMapping
    @ApiOperation("Créer un patient.")
    public ResponseEntity<Void> save(@RequestBody final PatientDTO patientDTO) {
        final PatientDTO createdPatient = patientService.save(patientDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPatient.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Mettre à jour un patient.")
    public void updateOne(@PathVariable final Integer id,
                          @RequestBody final PatientDTO patientDTO) {
        patientService.updateOne(patientDTO, id);
    }
}
