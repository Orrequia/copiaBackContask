package com.fot.backcontask.controller;

import com.fot.backcontask.dto.donglecomplement.DongleComplementDTO;
import com.fot.backcontask.model.DongleComplement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dongleComplement")
public class DongleComplementController extends AbstractController<DongleComplement, DongleComplementDTO>{
}
