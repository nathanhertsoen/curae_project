package com.ulco.curae.service;

import com.ulco.curae.dto.DoctorDTO;
import com.ulco.curae.dto.ServiceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceService {
    List<ServiceDTO> getAll();
    ServiceDTO findById(Integer id);


    ServiceDTO save(ServiceDTO serviceDTO);
    void updateOne(ServiceDTO serviceDTO, Integer id);

}
