package com.ulco.curae.dto;

import com.ulco.curae.enums.SexeTypeEnum;
import com.ulco.curae.model.ServiceDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor // prends tous les apramètre de notre classe en entrée
@NoArgsConstructor // ajouter un constructeur par défaut

public class ServiceDTO {

    @ApiModelProperty("id du service")
    @Null(message = "L'id doit être vide à la création")
    protected Integer id;

    @ApiModelProperty("nom du service")
    @NotBlank(message = "Le service a besoin d'un nom ")
    @Size(min = 1, max = 20, message = "le nom du service doit être compris entre 1 et 150 caractères")
    protected String name;

    @ApiModelProperty("description du service")
    @NotBlank(message = "description nécessaire")
    @Size(min = 1, max = 150, message = "la description du service doit être compris entre 1 et 150 caractères")
    protected String description;



    public ServiceDO toServiceDO(){
        ServiceDO serviceDO = new ServiceDO();
        serviceDO.setId(id);
        serviceDO.setName(name);
        serviceDO.setDescription(description);

        return serviceDO;
    }
}
