package com.fot.backcontask.service.activecatalog;

import com.fot.backcontask.dao.ActiveCatalogDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.ActiveCatalog;
import com.fot.backcontask.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ActiveCatalogServiceImpl extends AbstractService<ActiveCatalog, ActiveCatalogDAO> implements ActiveCatalogService {

    @Override
    public ActiveCatalog getAndCheck(Long id) throws NotFoundException {
        return findById(id).orElseThrow(() -> new NotFoundException("El activo del catálogo no existe"));
    }

    @Override
    public boolean isEqual(ActiveCatalog u1, ActiveCatalog u2) {
        return StringUtils.equals(u1.getActivationCode(), u2.getActivationCode()) &&
                u1.getCatalog().equals(u2.getCatalog());
    }

    @Override
    public void setValues(ActiveCatalog to, ActiveCatalog from) {
        to.setActivationCode(from.getActivationCode());
        to.setCatalog(from.getCatalog());
    }
}
