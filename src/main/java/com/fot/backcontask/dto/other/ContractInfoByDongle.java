package com.fot.backcontask.dto.other;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class ContractInfoByDongle implements Serializable {
    Long idContractLine;
    String contractTypeName;
    Date contractEndDate;
    String dongleLicense;
    Boolean contractPaid;
}
