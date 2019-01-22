package com.fot.backcontask.component.mapper.catalog;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.catalog.ActiveCatalogDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.ActiveCatalog;
import com.fot.backcontask.service.catalog.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_={@Autowired})
public class ActiveCatalogMapperImpl extends AbstractMapper<ActiveCatalog, ActiveCatalogDTO>
        implements ActiveCatalogMapper {
    private final CatalogService catalogService;

    @Override
    public Class<? extends ActiveCatalogDTO> dtoClazz() {
        return ActiveCatalogDTO.class;
    }

    @Override
    public Class<? extends ActiveCatalog> modelClazz() {
        return ActiveCatalog.class;
    }

    @Override
    public ActiveCatalog dtoToModel(ActiveCatalogDTO dto) throws NotFoundException {
        return map(dto);
    }

    private ActiveCatalog map(ActiveCatalogDTO dto) throws NotFoundException {
        ActiveCatalog activeCatalog = dozer.map(dto, modelClazz());
        if(dto.getIdCatalog() != null) activeCatalog.setCatalog(catalogService.getAndCheck(dto.getIdCatalog()));
        return activeCatalog;
    }

    @Override
    public ActiveCatalogDTO modelToDto(ActiveCatalog model) {
        return map(model);
    }

    private ActiveCatalogDTO map(ActiveCatalog model) {
        ActiveCatalogDTO activeCatalogDTO = dozer.map(model, dtoClazz());
        activeCatalogDTO.setIdCatalog(model.getCatalog().getIdCatalog());
        return activeCatalogDTO;
    }
}
