package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.province.ProvinceDTO;
import com.fot.backcontask.model.Province;

@RestController
@RequestMapping("/province")
public class ProvinceController extends AbstractController<Province, ProvinceDTO>{

}
