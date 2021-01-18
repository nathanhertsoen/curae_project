package com.ulco.curae.service;

import com.ulco.curae.dto.DoctorDTO;
import com.ulco.curae.exception.NotFoundException;
import com.ulco.curae.mapper.IDoctorMapper;
import com.ulco.curae.model.DoctorDO;
import com.ulco.curae.repository.IDoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
//@Primary
//@Profile("development")
@Service("DoctorService")
public class DoctorService implements IDoctorService {

    @Autowired
    private IDoctorMapper doctorMapper;

    @Autowired
    private IDoctorRepository doctorRepository;



    @Override
    public List<DoctorDTO> getAll() {
        System.out.println(doctorRepository.count());
        return doctorRepository.findAll().stream()
                .map(DoctorDO::toDoctorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer countDoctors() {
        return (int) doctorRepository.count();
    }

    @Override
    public DoctorDTO findById(Integer id) {
        return doctorRepository.findById(id)
                .map(DoctorDO::toDoctorDTO)
                .orElseThrow(NotFoundException::new);
    }


//    Integer count=0;
//    DoctorService(){
//        count++;
//        log.info("Itération:"+count);
//    }




    @Override
    public DoctorDTO save(DoctorDTO doctorDTO) {

        final DoctorDO doctorToCreate = doctorMapper.toDoctorDO(doctorDTO);
        final DoctorDO createdDoctor = doctorRepository.save(doctorToCreate);

        return doctorMapper.toDoctorDTO(createdDoctor);
    }

    @Override
    public void deleteAll() {
        doctorRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public void updateOne(DoctorDTO doctorDTO, Integer id) {

        findById(id);
        DoctorDO doctorToUpdate = doctorMapper.toDoctorDO(doctorDTO);
        doctorToUpdate.setId(id);
        doctorRepository.save(doctorToUpdate);
    }
}
