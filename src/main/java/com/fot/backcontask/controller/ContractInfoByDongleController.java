package com.fot.backcontask.controller;

import com.fot.backcontask.dto.other.ContractInfoByDongle;
import com.fot.backcontask.dto.store.StoreDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Store;
import com.fot.backcontask.service.other.ContractInfoByDongleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/company/{idCompany}/store/{idStore}")
public class ContractInfoByDongleController {

    @Autowired
    ContractInfoByDongleService contractInfoByDongleService;

    @GetMapping("/contractInfoByDongle")
    public List<ContractInfoByDongle> findById(@PathVariable("idCompany") Long idCompany,
                                               @PathVariable("idStore") Long idStore) throws NotFoundException {
        return contractInfoByDongleService.getAllInfo(idCompany, idStore);
    }
}
