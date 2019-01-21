package com.fot.backcontask.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class DongleComplement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idDongleComplement;

    @Column(nullable=false, unique=true)
    private String name;

    @Column(nullable=false, unique=true)
    private String activationCode;
}
