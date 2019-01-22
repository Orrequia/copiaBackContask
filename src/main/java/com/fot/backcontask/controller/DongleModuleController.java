package com.fot.backcontask.controller;

import com.fot.backcontask.dto.dongle.DongleModuleDTO;
import com.fot.backcontask.model.DongleModule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/privilege")
public class DongleModuleController extends AbstractController<DongleModule, DongleModuleDTO> {
}
