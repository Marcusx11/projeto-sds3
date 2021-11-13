package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessRateDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;

	@GetMapping(path = "/getAllPaginated")
	public ResponseEntity<Page<SaleDTO>> findAllPaginated(Pageable pageable) {
		Page<SaleDTO> page = saleService.findAllPaginated(pageable);
		return ResponseEntity.ok(page);
	}

	@GetMapping(path = "/getSumBySeller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> list = saleService.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/getSuccessBySeller")
	public ResponseEntity<List<SaleSuccessRateDTO>> successRateGroupedBySeller() {
		List<SaleSuccessRateDTO> list = saleService.successRateGroupedBySeller();
		return ResponseEntity.ok(list);
	}
}
