package com.fot.backcontask.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ActiveDongleComplement {

    private static final String FIELD_IDDONGLECOMPLEMENT = "idDongleModule";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idActiveDongleComplement;

    @Column(nullable=false, unique=true)
    private String activationCode;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name=FIELD_IDDONGLECOMPLEMENT, nullable=false)
    private DongleComplement dongleComplement;
}
