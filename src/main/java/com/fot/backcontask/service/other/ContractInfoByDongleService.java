package com.fot.backcontask.service.other;

import com.fot.backcontask.dto.other.ContractInfoByDongle;
import com.fot.backcontask.exception.NotFoundException;

import java.util.List;

public interface ContractInfoByDongleService {
    List<ContractInfoByDongle> getAllInfo(Long idCompany, Long idStore) throws NotFoundException;
}
