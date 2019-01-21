package com.fot.backcontask.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class DongleModule {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idDongleModule;

    @Column(nullable=false, unique=true)
    private Integer referenceCode;

    @Column(nullable=false, unique=true)
    private String name;
}
