package com.fot.backcontask.component.mapper.dongle;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.dongle.DongleModuleDTO;
import com.fot.backcontask.model.DongleModule;

public class DongleModuleMapperImpl extends AbstractMapper<DongleModule, DongleModuleDTO> implements DongleModuleMapper {

    @Override
    public Class<? extends DongleModuleDTO> dtoClazz() {
        return DongleModuleDTO.class;
    }

    @Override
    public Class<? extends DongleModule> modelClazz() {
        return DongleModule.class;
    }
}
