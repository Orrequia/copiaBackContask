package com.fot.backcontask.service.dongle;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.DongleDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Dongle;
import com.fot.backcontask.service.AbstractService;

@Service
public class DongleServiceImpl extends AbstractService<Dongle, DongleDAO> implements DongleService {

	@Override
	public Dongle getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("La mochila no existe"));
	}

	@Override
	public boolean isEqual(Dongle d1, Dongle d2) {
		return StringUtils.equals(d1.getLicense(), d2.getLicense()) &&
				d1.getDongleType().getIdDongleType().equals(d2.getDongleType().getIdDongleType()) &&
				d1.getDongleModule().getIdDongleModule().equals(d2.getDongleModule().getIdDongleModule()) &&

				d1.getActiveDongleComplement().stream().allMatch(activeDongleComplement ->
						d2.getActiveDongleComplement().stream().anyMatch(activeDongleComplement2 ->
								activeDongleComplement.getIdActiveDongleComplement()
										.equals(activeDongleComplement2.getIdActiveDongleComplement()))) &&
				d2.getActiveDongleComplement().stream().allMatch(activeDongleComplement ->
						d1.getActiveDongleComplement().stream().anyMatch(activeDongleComplement2 ->
								activeDongleComplement.getIdActiveDongleComplement()
										.equals(activeDongleComplement2.getIdActiveDongleComplement()))) &&

				d1.getActiveCatalog().stream().allMatch(activeCatalog ->
						d2.getActiveCatalog().stream().anyMatch(activeCatalog2 ->
								activeCatalog.getIdActiveCatalog()
										.equals(activeCatalog2.getIdActiveCatalog()))) &&
				d2.getActiveCatalog().stream().allMatch(activeCatalog ->
						d1.getActiveCatalog().stream().anyMatch(activeCatalog2 ->
								activeCatalog.getIdActiveCatalog()
										.equals(activeCatalog2.getIdActiveCatalog())));
	}

	@Override
	public void setValues(Dongle to, Dongle from) {
		to.setLicense(from.getLicense());
		to.setDongleType(from.getDongleType());
		to.setDongleModule(from.getDongleModule());
		to.setActiveDongleComplement(from.getActiveDongleComplement());
		to.setActiveCatalog(from.getActiveCatalog());
	}
}
