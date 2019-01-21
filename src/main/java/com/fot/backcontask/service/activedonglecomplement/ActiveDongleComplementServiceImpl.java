package com.fot.backcontask.service.activedonglecomplement;

import com.fot.backcontask.dao.ActiveDongleComplementDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.ActiveDongleComplement;
import com.fot.backcontask.service.AbstractService;
import org.apache.commons.lang3.StringUtils;

public class ActiveDongleComplementServiceImpl
        extends AbstractService<ActiveDongleComplement, ActiveDongleComplementDAO>
        implements ActiveDongleComplementService {

    @Override
    public ActiveDongleComplement getAndCheck(Long id) throws NotFoundException {
        return findById(id).orElseThrow(() -> new NotFoundException("El activo del complemento de mochila no existe"));
    }

    @Override
    public boolean isEqual(ActiveDongleComplement u1, ActiveDongleComplement u2) {
        return StringUtils.equals(u1.getActivationCode(), u2.getActivationCode()) &&
                u1.getDongleComplement().equals(u2.getDongleComplement());
    }

    @Override
    public void setValues(ActiveDongleComplement to, ActiveDongleComplement from) {
        to.setActivationCode(from.getActivationCode());
        to.setDongleComplement(from.getDongleComplement());
    }
}
