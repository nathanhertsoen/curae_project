package com.ulco.curae.service;

import com.ulco.curae.dto.HospitalizationDTO;
import com.ulco.curae.dto.ServiceDTO;
import com.ulco.curae.exception.NotFoundException;
import com.ulco.curae.mapper.IServiceMapper;
import com.ulco.curae.model.ServiceDO;
import com.ulco.curae.repository.IHospitalizationRepository;
import com.ulco.curae.repository.IServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
//@Primary
//@Profile("development")
@Service("ServiceService")
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceMapper serviceMapper;

    @Autowired
    private IServiceRepository serviceRepository;



    @Autowired
    private IHospitalizationService hospitalizationService;


    @Override
    public List<HospitalizationDTO> findServiceHospitalization(Integer id){
        return hospitalizationService.findHospitalizationByServiceId(id);
    }

//    @Override
//    public List<ServiceDTO> findNameById(Integer id){
//        return serviceRepository.findByName(id).stream()
//                .map(serviceRepository::toServiceDTO)
//                .collect(Collectors.toList());
//    }





















    @Override
    public Integer countServices() {
        return (int) serviceRepository.count();
    }


    @Override
    public List<ServiceDTO> getAll() {
        System.out.println(serviceRepository.count());
        return serviceRepository.findAll().stream()
                .map(ServiceDO::toServiceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceDTO findById(Integer id) {
        return serviceRepository.findById(id)
                .map(ServiceDO::toServiceDTO)
                .orElseThrow(NotFoundException::new);
    }




    @Override
    public ServiceDTO save(ServiceDTO serviceDTO) {

        final ServiceDO serviceToCreate = serviceMapper.toServiceDO(serviceDTO);
        final ServiceDO createdService = serviceRepository.save(serviceToCreate);

        return serviceMapper.toServiceDTO(createdService);
    }

    @Override
    public void updateOne(ServiceDTO serviceDTO, Integer id) {

        findById(id);
        ServiceDO serviceToUpdate = serviceMapper.toServiceDO(serviceDTO);
        serviceToUpdate.setId(id);
        serviceRepository.save(serviceToUpdate);
    }
}
