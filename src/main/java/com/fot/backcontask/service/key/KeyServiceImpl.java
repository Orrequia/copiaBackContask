package com.fot.backcontask.service.key;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.KeyDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Key;
import com.fot.backcontask.service.AbstractService;

@Service
public class KeyServiceImpl extends AbstractService<Key, KeyDAO> implements KeyService {

	@Override
	public Key getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("La mochila no exite"));
	}

	@Override
	public boolean isEqual(Key k1, Key k2) {
		return StringUtils.equals(k1.getLicense(), k2.getLicense()) &&
				k1.getKeyType().equals(k2.getKeyType());
	}

	@Override
	public void setValues(Key to, Key from) {
		to.setLicense(from.getLicense());
		to.setKeyType(from.getKeyType());
	}
}
