package com.ulco.curae.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ulco.curae.model.HospitalizationDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    private Integer id;

    @ApiModelProperty("id du service de l'hospitalisation")
    @Positive(message ="L'id doit être positive")
    private Integer serviceId;

    @ApiModelProperty("id du docteur de l'hospitalisation")
    @Positive(message ="L'id doit être positive")
    private Integer doctorId;

    @ApiModelProperty("id du patient de l'hospitalisation")
    @Positive(message ="L'id doit être positive")
    private Integer patientId;

    @JsonFormat(pattern="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("date de début d'hospitalisation")
    @NotNull(message ="L'hospitalisation doit avoir une date de départ")
    private Date startDate;

    @JsonFormat(pattern="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("date de fin d'hospitalisation")
    @NotNull(message ="L'hospitalisation doit avoir une date de fin")
    private Date endDate;


    public HospitalizationDO toHospitalizationDO(){


        HospitalizationDO hospitalizationDO = new HospitalizationDO();
        hospitalizationDO.setId(id);
        hospitalizationDO.setServiceId(serviceId);
        hospitalizationDO.setDoctorId(doctorId);
        hospitalizationDO.setPatientId(patientId);


        hospitalizationDO.setStartDate(startDate);
        hospitalizationDO.setEndDate(endDate);

    return hospitalizationDO;
    }

}
