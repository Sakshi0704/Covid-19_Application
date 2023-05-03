package com.covid.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;
	
	private String vaccineName;
	
	private String description;
	
	@Embedded
	private VaccineCount vaccineCount;
	
	
	
}
