package com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional
	public List<SellerDTO> findAll() {
		List<Seller> result = sellerRepository.findAll();
		
		// Realiza o mapeamento das entidades "Seller" para o "SellerDTO"
		return result.stream().map(s -> new SellerDTO(s)).collect(Collectors.toList());
	}
}
