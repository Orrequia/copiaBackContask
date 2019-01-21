package com.fot.backcontask.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ActiveCatalog {

    private static final String FIELD_IDCATALOG = "idCatalog";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idActiveCatalog;

    @Column(nullable=false, unique=true)
    private String activationCode;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name=FIELD_IDCATALOG, nullable=false)
    private Catalog catalog;
}
