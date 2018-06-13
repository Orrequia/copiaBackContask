package com.fot.backConTask.service.key;

import org.springframework.stereotype.Service;

import com.fot.backConTask.dao.KeyDAO;
import com.fot.backConTask.model.Key;
import com.fot.backConTask.service.AbstractService;

@Service
public class KeyServiceImpl extends AbstractService<Key, KeyDAO> implements KeyService {

}
