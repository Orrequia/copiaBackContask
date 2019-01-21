package com.fot.backcontask.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Catalog {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idContractType;

    @Column(nullable=false, unique=true)
    private Integer catalogCode;

    @Column(nullable=false, unique=true)
    private String name;
}
