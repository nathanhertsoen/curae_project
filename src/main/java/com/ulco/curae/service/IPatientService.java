package com.ulco.curae.service;

import com.ulco.curae.dto.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPatientService {
    List<PatientDTO> getAll();
    PatientDTO findById(Integer id);
    Integer countPatients();

    PatientDTO save(PatientDTO patientDTO);
    void updateOne(PatientDTO patientDTO, Integer id);

    void deleteById(Integer id);
    void deleteAll();

}
