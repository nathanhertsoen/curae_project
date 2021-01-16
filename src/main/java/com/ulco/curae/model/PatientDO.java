package com.ulco.curae.model;

import com.ulco.curae.dto.PatientDTO;
import com.ulco.curae.dto.PokemonDTO;
import com.ulco.curae.enums.HumanTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class PatientDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "firstname")
    protected String firstname;

    @Column(name = "lastname")
    protected String lastname;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexe")
    protected HumanTypeEnum humanType;


    @Transient
    public PatientDTO toPatientDTO() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(id);
        patientDTO.setFirstname(firstname);
        patientDTO.setLastname(lastname);
        patientDTO.setHumanType(humanType);

        return patientDTO;
    }
}
