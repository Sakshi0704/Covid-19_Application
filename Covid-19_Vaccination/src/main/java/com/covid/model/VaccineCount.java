package com.covid.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class VaccineCount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineCountId;
	
	private Integer quantity;
	private Double price;
	
	@ManyToOne
	private VaccineInventory vaccineInventory;
	
	@OneToOne
	private Vaccine vaccine;
	
}
