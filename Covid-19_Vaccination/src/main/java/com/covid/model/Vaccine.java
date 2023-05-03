package com.covid.model;



import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;
	
	private String vaccineName;
	
	private String description;
	
	
	@OneToOne
	private Member member;
	
	@OneToOne
	private VaccineCount vaccineCount;
	
}