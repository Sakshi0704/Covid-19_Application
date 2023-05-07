package com.covid.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Entity
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;
	
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String vaccineName;
	
	
	@NotNull
	private String description;
	
	
	// @OneToOne(cascade = CascadeType.ALL,mappedBy = "vaccine")
	// private VaccineCount vaccineCount;

	
	// @JsonIgnore
	// @OneToOne(cascade = CascadeType.ALL,mappedBy = "vaccine")
	// private Member member;
	
	
}