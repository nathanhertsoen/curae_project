package com.ulco.curae.mapper;

import com.ulco.curae.dto.ServiceDTO;
import com.ulco.curae.model.ServiceDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IServiceMapper {

    ServiceDTO toServiceDTO(ServiceDO serviceDO);
    ServiceDO toServiceDO(ServiceDTO serviceDTO);
}