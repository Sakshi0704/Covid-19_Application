package com.covid.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
public class VaccineInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineInventoryId;
	
	
	private LocalDate data;
	
	
//	@ManyToOne
//	private VaccinationCentre vaccinationCentre;
//	
	
	@OneToMany
	private VaccineCount vaccineCount; 
	
	
}
