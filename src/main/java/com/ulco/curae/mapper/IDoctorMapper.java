package com.ulco.curae.mapper;

import com.ulco.curae.dto.DoctorDTO;
import com.ulco.curae.dto.PokemonDTO;
import com.ulco.curae.model.DoctorDO;
import com.ulco.curae.model.PokemonDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDoctorMapper {

    DoctorDTO toDoctorDTO(DoctorDO doctorDO);
    DoctorDO toDoctorDO(DoctorDTO doctorDTO);
}