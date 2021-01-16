package com.ulco.curae.model;

import com.ulco.curae.dto.PokemonDTO;
import com.ulco.curae.dto.ServiceDTO;
import com.ulco.curae.enums.SexeTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "service")
public class ServiceDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @Transient
    public ServiceDTO toServiceDTO() {
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(id);
        serviceDTO.setName(name);
        serviceDTO.setDescription(description);


        return serviceDTO;
    }
}
