package com.fot.backcontask.controller;

import com.fot.backcontask.dto.catalog.ActiveCatalogDTO;
import com.fot.backcontask.model.ActiveCatalog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activeCatalog")
class ActiveCatalogController extends AbstractController<ActiveCatalog, ActiveCatalogDTO> {
}