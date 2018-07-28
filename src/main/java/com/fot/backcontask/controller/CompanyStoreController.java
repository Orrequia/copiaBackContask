package com.fot.backcontask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.component.mapper.store.StoreMapper;
import com.fot.backcontask.dto.store.StoreDTO;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Store;
import com.fot.backcontask.service.store.StoreService;

@RestController
@RequestMapping(value="/company/{idCompany}/store")
public class CompanyStoreController extends AbstractController<Store, StoreDTO>{
	
	@Autowired
	StoreService storeService;
	
	@Autowired
	StoreMapper storeMapper;
	
	@GetMapping
	public List<StoreDTO> findAll(@RequestParam(defaultValue = "0", required= false ) Integer page, 
							 @RequestParam(defaultValue = "10", required= false ) Integer size,
							 @PathVariable("idCompany") Long idCourse) throws NotFoundException {
		final List<Store> stores = storeService.findStoreByCompany(idCourse, PageRequest.of(page, size));
		return storeMapper.modelToDto(stores);
	}
	
	@GetMapping("/{idStore}")
	public StoreDTO findById(@PathVariable("idCourse") Long idCourse,
			 @PathVariable("idStore") Long idStore) throws NotFoundException {
		final Store store = storeService.findOneStoreByCompany(idCourse, idStore);
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
	public void delete(@PathVariable("idCourse") Long idCourse,
			@PathVariable("idStore") Long idStore, 
			@RequestBody StoreDTO dto) throws NotFoundException, InvalidRequestException {
		storeService.deleteToCompany(idCourse, idStore, storeMapper.dtoToModel(dto));
	}
}
