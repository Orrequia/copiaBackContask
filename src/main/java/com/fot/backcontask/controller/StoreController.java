package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.store.StoreDTO;
import com.fot.backcontask.model.Store;

@RestController
@RequestMapping("/store")
public class StoreController extends AbstractController<Store, StoreDTO>{

}
