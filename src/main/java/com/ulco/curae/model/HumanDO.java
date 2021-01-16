package com.ulco.curae.model;

import com.ulco.curae.enums.SexeTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class HumanDO {

    @Column(name = "firstname")
    protected String firstname;

    @Column(name = "lastname")
    protected String lastname;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexe")
    protected SexeTypeEnum sexe;
}

