package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleSuccessRateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Long visited;
	private Long deals;
	
	public SaleSuccessRateDTO(Seller seller, Long visited, Long deals) {
		if (seller == null) {
			return;
		}
		
		this.sellerName = seller.getName();
		this.visited = visited;
		this.deals = deals;
	}
}
