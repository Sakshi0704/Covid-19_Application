package com.covid.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class VaccineCount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineCountId;
	
	private Integer quantity;
	private Double price;
	
	@Embedded
	private VaccineInventory vaccineInventory;
	
}
