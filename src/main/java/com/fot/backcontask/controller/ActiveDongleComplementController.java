package com.fot.backcontask.controller;

import com.fot.backcontask.dto.donglecomplement.ActiveDongleComplementDTO;
import com.fot.backcontask.model.ActiveDongleComplement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activeDongleComplement")
public class ActiveDongleComplementController extends AbstractController<ActiveDongleComplement, ActiveDongleComplementDTO> {
}
