package com.ulco.curae.service;

import com.ulco.curae.dto.HospitalizationDTO;
import com.ulco.curae.dto.ServiceHospitalizationDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IHospitalizationService {
    List<HospitalizationDTO> getAll();
    List<HospitalizationDTO> findHospitalizationByServiceId(Integer id);
    HospitalizationDTO findById(Integer id);

    ServiceHospitalizationDTO countHospitalizations();

    HospitalizationDTO save(HospitalizationDTO hospitalizationDTO);
    void updateOne(HospitalizationDTO hospitalizationDTO, Integer id);

    List<HospitalizationDTO> getAllCurrentHospitalizations();

    void deleteById(Integer id);


}
