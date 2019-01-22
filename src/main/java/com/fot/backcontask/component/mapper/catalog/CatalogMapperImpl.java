package com.fot.backcontask.component.mapper.catalog;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.catalog.CatalogDTO;
import com.fot.backcontask.model.Catalog;
import org.springframework.stereotype.Component;

@Component
public class CatalogMapperImpl extends AbstractMapper<Catalog, CatalogDTO> implements CatalogMapper {

    @Override
    public Class<? extends CatalogDTO> dtoClazz() {
        return CatalogDTO.class;
    }

    @Override
    public Class<? extends Catalog> modelClazz() {
        return Catalog.class;
    }
}
