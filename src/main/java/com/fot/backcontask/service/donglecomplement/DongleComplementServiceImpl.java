package com.fot.backcontask.service.donglecomplement;

import com.fot.backcontask.dao.DongleComplementDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.DongleComplement;
import com.fot.backcontask.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DongleComplementServiceImpl extends AbstractService<DongleComplement, DongleComplementDAO> implements DongleComplementService {

    @Override
    public DongleComplement getAndCheck(Long id) throws NotFoundException {
        return findById(id).orElseThrow(() -> new NotFoundException("El complemento de mochila no existe"));
    }

    @Override
    public boolean isEqual(DongleComplement u1, DongleComplement u2) {
        return StringUtils.equals(u1.getName(), u2.getName()) &&
                u1.getActivationCode().equals(u2.getActivationCode());

    }

    @Override
    public void setValues(DongleComplement to, DongleComplement from) {
        to.setName(from.getName());
        to.setActivationCode(from.getActivationCode());
    }
}
