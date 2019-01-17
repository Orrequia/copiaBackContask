package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.population.PopulationDTO;
import com.fot.backcontask.model.Population;

@RestController
@RequestMapping("/population")
class PopulationController extends AbstractController<Population, PopulationDTO>{

}
