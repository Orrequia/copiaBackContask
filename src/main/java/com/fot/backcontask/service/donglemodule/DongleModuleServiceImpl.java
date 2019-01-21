package com.fot.backcontask.service.donglemodule;

import com.fot.backcontask.dao.DongleModuleDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.DongleModule;
import com.fot.backcontask.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DongleModuleServiceImpl extends AbstractService<DongleModule, DongleModuleDAO> implements DongleModuleService {

    @Override
    public DongleModule getAndCheck(Long id) throws NotFoundException {
        return findById(id).orElseThrow(() -> new NotFoundException("El módulo de mochila no existe"));
    }

    @Override
    public boolean isEqual(DongleModule u1, DongleModule u2) {
        return StringUtils.equals(u1.getName(), u2.getName()) &&
                u1.getReferenceCode().equals((u2.getReferenceCode()));
    }

    @Override
    public void setValues(DongleModule to, DongleModule from) {
        to.setName(from.getName());
        to.setReferenceCode(from.getReferenceCode());
    }
}
