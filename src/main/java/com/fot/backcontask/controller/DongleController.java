package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fot.backcontask.dto.dongle.DongleDTO;
import com.fot.backcontask.model.Dongle;

@RestController
@RequestMapping(value="/dongle")
class DongleController extends AbstractController<Dongle, DongleDTO> {

}
