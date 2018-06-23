package com.fot.backcontask.service.key;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.KeyDAO;
import com.fot.backcontask.model.Key;
import com.fot.backcontask.service.AbstractService;

@Service
public class KeyServiceImpl extends AbstractService<Key, KeyDAO> implements KeyService {

}
