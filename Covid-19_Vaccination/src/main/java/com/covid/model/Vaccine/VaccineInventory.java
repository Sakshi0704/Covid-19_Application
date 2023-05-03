package com.covid.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Data
@Entity
public class VaccineInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineInventoryId;
	
	
	private LocalDate data;
	
	
	
	
	
}
