package com.ulco.curae.service;

import com.ulco.curae.dto.HospitalizationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHospitalizationService {
    List<HospitalizationDTO> getAll();
    HospitalizationDTO findById(Integer id);


    HospitalizationDTO save(HospitalizationDTO hospitalizationDTO);
    void updateOne(HospitalizationDTO hospitalizationDTO, Integer id);

    void deleteById(Integer id);


}
