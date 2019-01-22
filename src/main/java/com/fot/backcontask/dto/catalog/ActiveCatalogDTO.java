package com.fot.backcontask.dto.catalog;

import lombok.Data;

import java.io.Serializable;

@Data
public class ActiveCatalogDTO implements Serializable {

    private Long idActiveCatalog;
    private String activationCode;
    private Long idCatalog;
}
