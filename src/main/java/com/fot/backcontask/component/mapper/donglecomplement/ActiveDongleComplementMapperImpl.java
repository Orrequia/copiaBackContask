package com.fot.backcontask.component.mapper.donglecomplement;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.donglecomplement.ActiveDongleComplementDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.ActiveDongleComplement;
import com.fot.backcontask.service.donglecomplement.DongleComplementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_={@Autowired})
public class ActiveDongleComplementMapperImpl
        extends AbstractMapper<ActiveDongleComplement, ActiveDongleComplementDTO>
        implements ActiveDongleComplementMapper {

    private final DongleComplementService dongleComplementService;

    @Override
    public Class<? extends ActiveDongleComplementDTO> dtoClazz() {
        return ActiveDongleComplementDTO.class;
    }

    @Override
    public Class<? extends ActiveDongleComplement> modelClazz() {
        return ActiveDongleComplement.class;
    }

    @Override
    public ActiveDongleComplement dtoToModel(ActiveDongleComplementDTO dto) throws NotFoundException {
        return map(dto);
    }

    private ActiveDongleComplement map(ActiveDongleComplementDTO dto) throws NotFoundException {
        ActiveDongleComplement activeDongleComplement = dozer.map(dto, modelClazz());
        if(dto.getIdDongleComplement() != null) activeDongleComplement.setDongleComplement(dongleComplementService.getAndCheck(dto.getIdDongleComplement()));
        return activeDongleComplement;
    }

    @Override
    public ActiveDongleComplementDTO modelToDto(ActiveDongleComplement model) {
        return map(model);
    }

    private ActiveDongleComplementDTO map(ActiveDongleComplement model) {
        ActiveDongleComplementDTO activeDongleComplementDTO = dozer.map(model, dtoClazz());
        activeDongleComplementDTO.setIdDongleComplement(model.getDongleComplement().getIdDongleComplement());
        return activeDongleComplementDTO;
    }
}
