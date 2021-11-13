package com.devsuperior.dsvendas.dto;


import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleSumDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Double sum;
	
	public SaleSumDTO(Seller seller, Double sum) {
		if (seller == null) {
			return;
		}
		
		this.sellerName = seller.getName();
		this.sum = sum;
	}
}
