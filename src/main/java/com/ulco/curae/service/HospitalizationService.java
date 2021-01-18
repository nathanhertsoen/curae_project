package com.ulco.curae.service;

import com.ulco.curae.dto.HospitalizationDTO;
import com.ulco.curae.exception.NotFoundException;
import com.ulco.curae.mapper.IHospitalizationMapper;
import com.ulco.curae.model.HospitalizationDO;
import com.ulco.curae.repository.IHospitalizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
//@Primary
//@Profile("development")
@Service("HospitalizationService")
public class HospitalizationService implements IHospitalizationService {

    @Autowired
    private IHospitalizationMapper hospitalizationMapper;

    @Autowired
    private IHospitalizationRepository hospitalizationRepository;

    @Override
    public List<HospitalizationDTO> getAll() {
        return hospitalizationRepository.findAll().stream()
                .map(HospitalizationDO::toHospitalizationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HospitalizationDTO findById(Integer id) {
        return hospitalizationRepository.findById(id)
                .map(HospitalizationDO::toHospitalizationDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public HospitalizationDTO save(HospitalizationDTO hospitalizationDTO) {



        final HospitalizationDO doctorToCreate = hospitalizationMapper.toHospitalizationDO(hospitalizationDTO);
        final HospitalizationDO createdDoctor = hospitalizationRepository.save(doctorToCreate);

        return hospitalizationMapper.toHospitalizationDTO(createdDoctor);
    }

    @Override
    public void deleteById(Integer id) {
        hospitalizationRepository.deleteById(id);
    }

    @Override
    public void updateOne(HospitalizationDTO hospitalizationDTO, Integer id) {

        findById(id);
        HospitalizationDO hospitalizationToUpdate = hospitalizationMapper.toHospitalizationDO(hospitalizationDTO);
        hospitalizationToUpdate.setId(id);
        hospitalizationRepository.save(hospitalizationToUpdate);
    }
}
