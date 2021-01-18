package com.ulco.curae.service;

import com.ulco.curae.dto.PatientDTO;
import com.ulco.curae.exception.NotFoundException;
import com.ulco.curae.mapper.IPatientMapper;
import com.ulco.curae.model.PatientDO;
import com.ulco.curae.repository.IPatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
//@Primary
//@Profile("development")
@Service("PatientService")
public class PatientService implements IPatientService {

    @Autowired
    private IPatientMapper patientMapper;

    @Autowired
    private IPatientRepository patientRepository;


    @Override
    public Integer countPatients() {
        return (int) patientRepository.count();
    }



    @Override
    public List<PatientDTO> getAll() {
        System.out.println(patientRepository.count());
        return patientRepository.findAll().stream()
                .map(PatientDO::toPatientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO findById(Integer id) {
        return patientRepository.findById(id)
                .map(PatientDO::toPatientDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public PatientDTO save(PatientDTO doctorDTO) {

        final PatientDO patientToCreate = patientMapper.toPatientDO(doctorDTO);
        final PatientDO createdPatient = patientRepository.save(patientToCreate);

        return patientMapper.toPatientDTO(createdPatient);
    }

    @Override
    public void deleteAll() {
        patientRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void updateOne(PatientDTO doctorDTO, Integer id) {

        findById(id);
        PatientDO patientToUpdate = patientMapper.toPatientDO(doctorDTO);
        patientToUpdate.setId(id);
        patientRepository.save(patientToUpdate);
    }
}
