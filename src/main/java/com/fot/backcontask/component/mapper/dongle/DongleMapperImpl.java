package com.fot.backcontask.component.mapper.dongle;

import com.fot.backcontask.model.*;
import com.fot.backcontask.service.activecatalog.ActiveCatalogService;
import com.fot.backcontask.service.activedonglecomplement.ActiveDongleComplementService;
import com.fot.backcontask.service.donglemodule.DongleModuleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.dongle.DongleDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.service.dongletype.DongleTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor_={@Autowired})
public class DongleMapperImpl extends AbstractMapper<Dongle, DongleDTO> implements DongleMapper {

	final private DongleTypeService dongleTypeService;
	final private DongleModuleService dongleModuleService;
	final private ActiveCatalogService activeCatalogService;
	final private ActiveDongleComplementService activeDongleComplementService;
	
	@Override
	public Class<? extends DongleDTO> dtoClazz() {
		return DongleDTO.class;
	}

	@Override
	public Class<? extends Dongle> modelClazz() {
		return Dongle.class;
	}

	@Override
	public Dongle dtoToModel(DongleDTO dto) throws NotFoundException {
		return map(dto,
				longToActiveDongleComplement(dto.getActiveDongleComplements()),
				longToActiveCatalog(dto.getActiveCatalogs()));
	}
	
	private Dongle map(DongleDTO dto,
					   List<ActiveDongleComplement> activeDongleComplement,
					   List<ActiveCatalog> activeCatalog) throws NotFoundException {

		Dongle dongle = dozer.map(dto, modelClazz());
		if(dto.getIdDongleType() != null) dongle.setDongleType(dongleTypeService.getAndCheck(dto.getIdDongleType()));
		if(dto.getIdDongleModule() != null) dongle.setDongleModule(dongleModuleService.getAndCheck(dto.getIdDongleModule()));
		return dongle;
	}

	private List<ActiveDongleComplement> longToActiveDongleComplement(final List<Long> activeDongleComplements) throws NotFoundException {
		if(activeDongleComplements != null) {
			List<ActiveDongleComplement> activeDongleComplement = activeDongleComplements
					.stream().map(activeDongleComplementService::findById)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList());
			if(activeDongleComplement.size() != activeDongleComplements.size())
				throw new NotFoundException("Algunos o todos los activos de complementos de mochila no existen");
			return activeDongleComplement;
		}
		return new ArrayList<>();
	}

	private List<ActiveCatalog> longToActiveCatalog(final List<Long> activeCatalogs) throws NotFoundException {
		if(activeCatalogs != null) {
			List<ActiveCatalog> activeCatalog = activeCatalogs
					.stream().map(activeCatalogService::findById)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList());
			if(activeCatalog.size() != activeCatalogs.size())
				throw new NotFoundException("Algunos o todos los activos de catálogos no existen");
			return activeCatalog;
		}
		return new ArrayList<>();
	}

	@Override
	public DongleDTO modelToDto(Dongle model) {
		return map(model,
				activeDongleComplementToLong(model.getActiveDongleComplement()),
				activeCatalogToLong(model.getActiveCatalog()));
	}
	
	private DongleDTO map(Dongle model, final List<Long> activeDongleComplements, final List<Long> activeCatalogs) {
		DongleDTO dongleDTO = dozer.map(model, dtoClazz());
		dongleDTO.setIdDongleType(model.getDongleType().getIdDongleType());
		dongleDTO.setIdDongleModule(model.getDongleModule().getIdDongleModule());
		dongleDTO.setActiveDongleComplements(activeDongleComplements);
		dongleDTO.setActiveCatalogs(activeCatalogs);
		return dongleDTO;
	}

	private List<Long> activeDongleComplementToLong(final List<ActiveDongleComplement> store) {
		return store.stream().map(ActiveDongleComplement::getIdActiveDongleComplement).collect(Collectors.toList());
	}

	private List<Long> activeCatalogToLong(final List<ActiveCatalog> contract) {
		return contract.stream().map(ActiveCatalog::getIdActiveCatalog).collect(Collectors.toList());
	}
}
