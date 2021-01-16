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

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hospitalizations")
public class HospitalizationController {
    @ApiModelProperty("Powered by Hertsoen Technology ©")

    @Autowired
    private IPatientService patientService;

    @GetMapping
    @ApiOperation("Selectionner toutes les hospitalisations.")
    public List<PatientDTO> getAll() {
        return patientService.getAll();
    }


    @GetMapping("/{id}")
    @ApiOperation("Selectionner une hospitalisation.")
    public PatientDTO findById(@PathVariable Integer id) {
        return patientService.findById(id);
    }


    @PostMapping
    @ApiOperation("Créer une hospitalisation.")
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
    @ApiOperation("Mettre à jour une hospitalisation.")
    public void updateOne(@PathVariable final Integer id,
                          @RequestBody final PatientDTO patientDTO) {
        patientService.updateOne(patientDTO, id);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @ApiOperation("Supprimer une hospitalisation.")
    public void deleteById(@PathVariable Integer id) {
        patientService.deleteById(id);
    }
}
