package com.ulco.curae.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor // prends tous les paramètres de notre classe en entrée
@NoArgsConstructor // ajouter un constructeur par défaut

//Chose 'callSuper=true' if
// - you are inheriting from a superclass that either has no state information,
// - or itself is using the @Data annotation,
// - or has implementations of equals/hash that "handle the situation properly"

public class StatDTO  {

  Integer nbDoctors;
  Integer nbPatients;
  Integer nbServices;
  List<ServiceHospitalizationDTO> serviceHospitalisations;
}
