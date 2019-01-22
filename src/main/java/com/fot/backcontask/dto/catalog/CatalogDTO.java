package com.fot.backcontask.dto.catalog;

import lombok.Data;

import java.io.Serializable;

@Data
public class CatalogDTO implements Serializable {

    private Long idContractType;
    private Integer catalogCode;
    private String name;
}
