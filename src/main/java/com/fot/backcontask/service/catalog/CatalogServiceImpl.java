package com.fot.backcontask.service.catalog;

import com.fot.backcontask.dao.CatalogDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Catalog;
import com.fot.backcontask.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl extends AbstractService<Catalog, CatalogDAO> implements CatalogService {

    @Override
    public Catalog getAndCheck(Long id) throws NotFoundException {
        return findById(id).orElseThrow(() -> new NotFoundException("El catálogo no existe"));
    }

    @Override
    public boolean isEqual(Catalog u1, Catalog u2) {
        return StringUtils.equals(u1.getName(), u2.getName()) &&
                u1.getCatalogCode().equals(u2.getCatalogCode());
    }

    @Override
    public void setValues(Catalog to, Catalog from) {
        to.setName(from.getName());
        to.setCatalogCode(from.getCatalogCode());
    }
}
