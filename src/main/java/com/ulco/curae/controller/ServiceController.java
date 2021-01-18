package com.ulco.curae.controller;

import com.ulco.curae.dto.HospitalizationDTO;
import com.ulco.curae.dto.ServiceDTO;
import com.ulco.curae.service.IServiceService;
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
@RequestMapping("/services")
public class ServiceController {
    @ApiModelProperty("Powered by Hertsoen Technology ©")

    @Autowired
    private IServiceService serviceService;

    @GetMapping
    @ApiOperation("Selectionner tous les services.")
    public List<ServiceDTO> getAll() {
        return serviceService.getAll();
    }


    @GetMapping("/{id}/hospitalizations")
    @ApiOperation("Liste des hospitalisations qui ont eu lieu dans ce service.")
    public List<HospitalizationDTO> findServiceHospitalization(@PathVariable Integer id){
    return serviceService.findServiceHospitalization(id);
    }


    @GetMapping("/{id}")
    @ApiOperation("Selectionner un service.")
    public ServiceDTO findById(@PathVariable Integer id) {
        return serviceService.findById(id);
    }

    @PostMapping
    @ApiOperation("Créer un service.")
    public ResponseEntity<Void> save(@RequestBody final ServiceDTO serviceDTO) {
        final ServiceDTO createdService = serviceService.save(serviceDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdService.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Mettre à jour un service.")
    public void updateOne(@PathVariable final Integer id, @RequestBody final ServiceDTO serviceDTO) {
        serviceService.updateOne(serviceDTO, id);
    }
}
