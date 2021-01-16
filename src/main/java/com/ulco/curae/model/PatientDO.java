package com.ulco.curae.model;

import com.ulco.curae.dto.PatientDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class PatientDO extends HumanDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Transient
    public PatientDTO toPatientDTO() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(id);
        patientDTO.setFirstname(firstname);
        patientDTO.setLastname(lastname);
        patientDTO.setSexe(sexe);

        return patientDTO;
    }
}
