package com.ulco.curae.service;

import com.ulco.curae.dto.HospitalizationDTO;
import com.ulco.curae.dto.ServiceHospitalizationDTO;
import com.ulco.curae.dto.StatDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
        List<HospitalizationDTO> currentHospitalization = hospitalizationService.getAllCurrentHospitalizations();
        Map<Integer, List<HospitalizationDTO>> currentHospitalizationByServiceId = currentHospitalization.stream().collect(Collectors.groupingBy(HospitalizationDTO::getServiceId));


        List<ServiceHospitalizationDTO> DTOList = currentHospitalizationByServiceId.entrySet().stream()
                .map(entry -> {
                    ServiceHospitalizationDTO serviceHospitalizationDTO = new ServiceHospitalizationDTO();
                    serviceHospitalizationDTO.setNbHospitalizations(entry.getValue().size());
                    serviceHospitalizationDTO.setServiceName(serviceService.findById(entry.getKey()).getName());
                    return serviceHospitalizationDTO; } ).collect(Collectors.toList());
        statDTO.setServiceHospitalisations(DTOList);
        return statDTO;
    }
}
