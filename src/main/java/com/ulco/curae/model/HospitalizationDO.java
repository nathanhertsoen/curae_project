package com.ulco.curae.model;

import com.ulco.curae.dto.DoctorDTO;
import com.ulco.curae.dto.HospitalizationDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "hospitalisation")
public class HospitalizationDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // between quote, names become case-sensitive, then use column named in uppercase to call the right column name
    @Column(name = "IDSERVICE")
    private Integer idService;

    @Column(name = "IDDOCTOR")
    private Integer idDoctor;

    @Column(name = "IDPATIENT")
    private Integer idPatient;

    @Column(name = "STARTDATE")
    private Date startDate;

    @Column(name = "ENDDATE")
    private Date endDate;


    @Transient
    public HospitalizationDTO toHospitalizationDTO() {
        HospitalizationDTO hospitalizationDTO = new HospitalizationDTO();
        hospitalizationDTO.setId(id);
        hospitalizationDTO.setIdService(idService);
        hospitalizationDTO.setIdDoctor(idDoctor);
        hospitalizationDTO.setIdPatient(idPatient);
        hospitalizationDTO.setStartDate(startDate);
        hospitalizationDTO.setEndDate(endDate);

        return hospitalizationDTO;
    }
}
