package com.covid.model;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;



@Data
@Getter
@Setter
@Entity
public class VaccineInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineInventoryId;
	
	
	@NotNull(message = "Date can not be null")
	@NotEmpty(message = "Date should be in valid formate")
	@JsonFormat(shape= JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy = "vaccineInventory")
	private  List<VaccinationCentre> vaccinationCenters;
	
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy = "vaccineInventory")
	private List<VaccineCount> vaccineCounts; 
	
	
}
