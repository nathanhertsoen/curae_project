package com.ulco.curae.mapper;

import com.ulco.curae.dto.PatientDTO;
import com.ulco.curae.model.PatientDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPatientMapper {

    PatientDTO toPatientDTO(PatientDO patientDO);
    PatientDO toPatientDO(PatientDTO patientDTO);
}