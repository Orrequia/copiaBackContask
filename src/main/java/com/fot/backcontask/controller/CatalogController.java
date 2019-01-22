package com.fot.backcontask.controller;

import com.fot.backcontask.dto.catalog.CatalogDTO;
import com.fot.backcontask.model.Catalog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController extends AbstractController<Catalog, CatalogDTO> {
}
