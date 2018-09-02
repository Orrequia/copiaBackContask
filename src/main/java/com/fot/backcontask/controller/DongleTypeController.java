package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.dongle.DongleTypeDTO;
import com.fot.backcontask.model.DongleType;

@RestController
@RequestMapping(value="/dongleType")
public class DongleTypeController extends AbstractController<DongleType, DongleTypeDTO>{

}
