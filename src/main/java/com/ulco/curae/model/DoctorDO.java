package com.ulco.curae.model;

import com.ulco.curae.dto.DoctorDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "docteur")
public class DoctorDO extends HumanDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // between quote, names become case-sensitive, then use column named in uppercase to call the right column name
    @Column(name = "SERVICEID")
    public Integer serviceId;

    @Transient
    public DoctorDTO toDoctorDTO() {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(id);
        doctorDTO.setFirstname(firstname);
        doctorDTO.setLastname(lastname);
        doctorDTO.setSexe(sexe);
        doctorDTO.setServiceId(serviceId);

        return doctorDTO;
    }
}
