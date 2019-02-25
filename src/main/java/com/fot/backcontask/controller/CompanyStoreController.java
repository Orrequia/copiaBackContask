package com.fot.backcontask.controller;

import com.fot.backcontask.component.mapper.store.StoreMapper;
import com.fot.backcontask.dto.store.StoreDTO;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Store;
import com.fot.backcontask.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/company/{idCompany}/store")
class CompanyStoreController {

	private final StoreService storeService;
	private final StoreMapper storeMapper;

	@Autowired
	public CompanyStoreController(StoreService storeService, StoreMapper storeMapper) {
		this.storeService = storeService;
		this.storeMapper = storeMapper;
	}

	@GetMapping
	public List<StoreDTO> findAll(@PathVariable("idCompany") Long idCompany) throws NotFoundException {
		final List<Store> stores = storeService.findStoreByCompany(idCompany);

		return storeMapper.modelToDto(stores);
	}
	
	@GetMapping("/{idStore}")
	public StoreDTO findById(@PathVariable("idCompany") Long idCompany,
			 @PathVariable("idStore") Long idStore) throws NotFoundException {
		final Store store = storeService.findOneStoreByCompany(idCompany, idStore);
		return storeMapper.modelToDto(store);
	}
	
	@PostMapping
	public StoreDTO create(@RequestBody StoreDTO dto,
			@PathVariable("idCompany") Long idCompany) throws InvalidRequestException, NotFoundException {
		if(dto.getIdStore() != null) 
			throw new InvalidRequestException("El idStore no se puede recibir en el body");
		Store createStore = storeService.addToCompany(idCompany, storeMapper.dtoToModel(dto));
		return storeMapper.modelToDto(createStore);
	}
	
	@PutMapping("/{idStore}")
	public void update(@PathVariable("idCompany") Long idCompany,
			@PathVariable("idStore") Long idStore, 
			@RequestParam(defaultValue = "false", required = false) Boolean autoQuestions,
			@RequestParam(defaultValue = "10", required = false) Integer nQuestions,
		    @RequestBody StoreDTO dto) throws InvalidRequestException, NotFoundException {
		if(dto.getIdStore() != null) 
			throw new InvalidRequestException("El idStore no se puede recibir en el body");
		storeService.updateToCompany(idCompany, idStore, storeMapper.dtoToModel(dto));
	}
	
	@DeleteMapping("/{idStore}")
	public void delete(@PathVariable("idCompany") Long idCompany,
			@PathVariable("idStore") Long idStore, 
			@RequestBody StoreDTO dto) throws NotFoundException, InvalidRequestException {
		storeService.deleteToCompany(idCompany, idStore, storeMapper.dtoToModel(dto));
	}
}
