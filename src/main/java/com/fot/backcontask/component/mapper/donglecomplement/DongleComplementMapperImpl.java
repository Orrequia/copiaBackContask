package com.fot.backcontask.component.mapper.donglecomplement;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.donglecomplement.DongleComplementDTO;
import com.fot.backcontask.model.DongleComplement;
import org.springframework.stereotype.Component;

@Component
public class DongleComplementMapperImpl extends AbstractMapper<DongleComplement, DongleComplementDTO> implements DongleComplementMapper {

    @Override
    public Class<? extends DongleComplementDTO> dtoClazz() {
        return DongleComplementDTO.class;
    }

    @Override
    public Class<? extends DongleComplement> modelClazz() {
        return DongleComplement.class;
    }
}
