package com.ulco.curae.service;

import com.ulco.curae.dto.HospitalizationDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IHospitalizationService {
    List<HospitalizationDTO> getAll();
    List<HospitalizationDTO> findHospitalizationByServiceId(Integer id);
    HospitalizationDTO findById(Integer id);


    HospitalizationDTO save(HospitalizationDTO hospitalizationDTO);
    void updateOne(HospitalizationDTO hospitalizationDTO, Integer id);


    void deleteById(Integer id);


}
