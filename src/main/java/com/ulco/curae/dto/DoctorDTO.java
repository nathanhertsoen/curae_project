package com.ulco.curae.dto;

import com.ulco.curae.model.DoctorDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor // prends tous les paramètres de notre classe en entrée
@NoArgsConstructor // ajouter un constructeur par défaut

//Chose 'callSuper=true' if
// - you are inheriting from a superclass that either has no state information,
// - or itself is using the @Data annotation,
// - or has implementations of equals/hash that "handle the situation properly"
@EqualsAndHashCode(callSuper = true)

public class DoctorDTO extends HumanDTO {

    @ApiModelProperty("id : service du docteur")
    @Positive(message ="L'id doit être positive")
    private Integer serviceId;


    public DoctorDO toDoctorDO(){
    DoctorDO doctorDO = new DoctorDO();

        doctorDO.setServiceId(serviceId);

    return doctorDO;
    }

}
