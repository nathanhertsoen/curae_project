package com.ulco.curae.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ulco.curae.dto.HospitalizationDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "hospitalization")
public class HospitalizationDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // between quote, names become case-sensitive, then use column named in uppercase to call the right column name
    @Column(name = "SERVICEID")
    private Integer serviceId;

    @Column(name = "DOCTORID")
    private Integer doctorId;

    @Column(name = "PATIENTID")
    private Integer patientId;


    @Column(name = "STARTDATE")
    private Date startDate;


    @Column(name = "ENDDATE")
    private Date endDate;


    @Transient
    public HospitalizationDTO toHospitalizationDTO() {
        HospitalizationDTO hospitalizationDTO = new HospitalizationDTO();
        hospitalizationDTO.setId(id);
        hospitalizationDTO.setServiceId(serviceId);
        hospitalizationDTO.setDoctorId(doctorId);
        hospitalizationDTO.setPatientId(patientId);
        hospitalizationDTO.setStartDate(startDate);
        hospitalizationDTO.setEndDate(endDate);

        return hospitalizationDTO;
    }
}
