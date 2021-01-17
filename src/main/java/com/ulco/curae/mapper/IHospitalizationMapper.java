package com.ulco.curae.mapper;

import com.ulco.curae.dto.HospitalizationDTO;
import com.ulco.curae.model.HospitalizationDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IHospitalizationMapper {

    HospitalizationDTO toHospitalizationDTO(HospitalizationDO hospitalizationDO);
    HospitalizationDO toHospitalizationDO(HospitalizationDTO hospitalizationDTO);
}