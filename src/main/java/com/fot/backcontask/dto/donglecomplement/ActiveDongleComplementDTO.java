package com.fot.backcontask.dto.donglecomplement;

import lombok.Data;

import java.io.Serializable;

@Data
public class ActiveDongleComplementDTO implements Serializable {

    private Long idActiveDongleComplement;
    private String activationCode;
    private Long idDongleComplement;
}
