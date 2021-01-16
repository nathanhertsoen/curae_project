package com.ulco.curae.dto;

import com.ulco.curae.model.DoctorDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Null;

@Data
@AllArgsConstructor // prends tous les paramètres de notre classe en entrée
@NoArgsConstructor // ajouter un constructeur par défaut
@EqualsAndHashCode(callSuper = true)
public class DoctorDTO extends HumanDTO{

    @ApiModelProperty("id : service du docteur")
    @Null(message ="L'id doit être vide à la création")
    private Integer serviceId;


    public DoctorDO toDoctorDO(){
    DoctorDO doctorDO = new DoctorDO();
        doctorDO.setId(id);
        doctorDO.setFirstname(firstname);
        doctorDO.setLastname(lastname);
        doctorDO.setHumanType(humanType);
        doctorDO.setServiceId(serviceId);

    return doctorDO;
    }

}
