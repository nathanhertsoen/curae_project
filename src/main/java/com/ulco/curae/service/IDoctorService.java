package com.ulco.curae.service;

import com.ulco.curae.dto.DoctorDTO;
import com.ulco.curae.dto.PokemonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDoctorService {
    List<DoctorDTO> getAll();
    Integer countDoctors();
    DoctorDTO findById(Integer id);


    DoctorDTO save(DoctorDTO doctorDTO);
    void updateOne(DoctorDTO doctorDTO, Integer id);

    void deleteById(Integer id);
    void deleteAll();

}
