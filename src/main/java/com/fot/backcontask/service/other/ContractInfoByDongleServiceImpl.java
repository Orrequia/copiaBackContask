package com.fot.backcontask.service.other;

import com.fot.backcontask.dto.other.ContractInfoByDongle;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.*;
import com.fot.backcontask.service.company.CompanyService;
import com.fot.backcontask.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ContractInfoByDongleServiceImpl implements ContractInfoByDongleService {

    private final StoreService storeService;
    private final CompanyService companyService;

    @Autowired
    public ContractInfoByDongleServiceImpl(CompanyService companyService, StoreService storeService) {
        this.companyService = companyService;
        this.storeService = storeService;
    }

    public List<ContractInfoByDongle> getAllInfo(Long idCompany, Long idStore) throws NotFoundException {
        List<Contract> contracts = companyService.getAndCheck(idCompany).getContract();
        List<Dongle> dongles = storeService.getAndCheck(idStore).getDongle();
        return createListContractInfoByDongles(contracts, dongles);
    }

    private List<ContractInfoByDongle> createListContractInfoByDongles(List<Contract> contracts, List<Dongle> dongles) {
        List<ContractInfoByDongle> contractInfoByDongles = new ArrayList<>();
        Date currentDate = new Date();
        contracts.forEach(contract ->
            contract.getContractLine().forEach(contractLine -> {
                if (dongles.contains(contractLine.getDongle())
                        && this.addOneYear(contract.getStartDate()).getTime() >= currentDate.getTime())
                    contractInfoByDongles.add(createContractInfoByDongles(contract, contractLine));
            })
        );
        return contractInfoByDongles;
    }

    private ContractInfoByDongle createContractInfoByDongles(Contract contract, ContractLine contractLine) {
        return new ContractInfoByDongle(contractLine.getIdContractLine(),
                contractLine.getContractType().getName(),
                addOneYear(contract.getStartDate()),
                contractLine.getDongle().getLicense(),
                contract.getPaid());
    }

    private Date addOneYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }
}
