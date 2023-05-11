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
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VaccineInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vaccineInventoryId;
	
	
	
	//@NotEmpty(message = "Date should be in valid formate")
	@JsonFormat(shape= JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd")
	private LocalDate date;
	

    @OneToMany(cascade = CascadeType.ALL)
    private List<Vaccine> vaccinelist = new ArrayList<>();


	// @JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	private  VaccinationCentre vaccinationCenter;
	

	
	
}
