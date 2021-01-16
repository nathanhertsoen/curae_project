package com.ulco.curae.dto;

import com.ulco.curae.model.DoctorDO;
import com.ulco.curae.model.HospitalizationDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@AllArgsConstructor // prends tous les paramètres de notre classe en entrée
@NoArgsConstructor // ajouter un constructeur par défaut

//Chose 'callSuper=true' if
// - you are inheriting from a superclass that either has no state information,
// - or itself is using the @Data annotation,
// - or has implementations of equals/hash that "handle the situation properly"


public class HospitalizationDTO{

    @ApiModelProperty("id hospitalisation")
    @Null(message = "L'id doit être vide à la création")
    protected Integer id;

    @ApiModelProperty("id du service de l'hospitalisation")
    @Positive(message ="L'id doit être positive")
    private Integer idService;

    @ApiModelProperty("id du docteur de l'hospitalisation")
    @Positive(message ="L'id doit être positive")
    private Integer idDoctor;

    @ApiModelProperty("id du patient de l'hospitalisation")
    @Positive(message ="L'id doit être positive")
    private Integer idPatient;

    @ApiModelProperty("date de début d'hospitalisation")
    @NotNull(message ="L'hospitalisation doit avoir une date de départ")
    private Date startDate;

    @ApiModelProperty("date de fin d'hospitalisation")
    @NotNull(message ="L'hospitalisation doit avoir une date de fin")
    private Date endDate;

    public HospitalizationDO toHospitalizationDO(){
        HospitalizationDO hospitalizationDO = new HospitalizationDO();
        hospitalizationDO.setId(id);
        hospitalizationDO.setIdService(idService);
        hospitalizationDO.setIdDoctor(idDoctor);
        hospitalizationDO.setIdPatient(idPatient);
        hospitalizationDO.setStartDate(startDate);
        hospitalizationDO.setEndDate(endDate);

    return hospitalizationDO;
    }

}
