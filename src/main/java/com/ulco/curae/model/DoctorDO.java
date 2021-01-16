package com.ulco.curae.model;

import com.ulco.curae.dto.DoctorDTO;
import com.ulco.curae.dto.PokemonDTO;
import com.ulco.curae.enums.HumanTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class DoctorDO extends HumanDO{

    @Column(name = "id de service")
    private Integer serviceId;

    @Transient
    public DoctorDTO toDoctorDTO() {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(id);
        doctorDTO.setFirstname(firstname);
        doctorDTO.setLastname(lastname);
        doctorDTO.setHumanType(humanType);
        doctorDTO.setServiceId(serviceId);

        return doctorDTO;
    }
}
