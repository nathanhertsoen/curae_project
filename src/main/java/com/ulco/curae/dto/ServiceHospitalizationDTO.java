package com.ulco.curae.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor // prends tous les paramètres de notre classe en entrée
@NoArgsConstructor // ajouter un constructeur par défaut




public class ServiceHospitalizationDTO {

    @ApiModelProperty("nom du service")
    private String serviceName;

    @ApiModelProperty("id")
    private Integer nbHospitalizations;



}
