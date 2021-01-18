package com.ulco.curae.service;

import com.ulco.curae.dto.StatDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
//@Primary
//@Profile("development")


@Service
public class StatService implements IStatService {

@Autowired
private IDoctorService doctorService;

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IPatientService patientService;


    @Autowired
    private IHospitalizationService hospitalizationService;


    @Override
    public StatDTO getStat() {
        StatDTO statDTO = new StatDTO();
        statDTO.setNbDoctors(doctorService.countDoctors());
        statDTO.setNbPatients(patientService.countPatients());
        statDTO.setNbServices(serviceService.countServices());
        return statDTO;
    }
}
