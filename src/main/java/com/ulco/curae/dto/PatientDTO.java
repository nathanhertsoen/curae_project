package com.ulco.curae.dto;

import com.ulco.curae.model.PatientDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor // prends tous les apramètre de notre classe en entrée


public class PatientDTO extends HumanDTO{


    public PatientDO toPatientDO() {
        PatientDO patientDO = new PatientDO();
        patientDO.setId(id);
        patientDO.setFirstname(firstname);
        patientDO.setLastname(lastname);
        patientDO.setSexe(sexe);

        return patientDO;
    }

}
