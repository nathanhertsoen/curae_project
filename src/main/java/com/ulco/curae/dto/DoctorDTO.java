package com.ulco.curae.dto;

import com.ulco.curae.enums.HumanTypeEnum;
import com.ulco.curae.model.DoctorDO;
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
