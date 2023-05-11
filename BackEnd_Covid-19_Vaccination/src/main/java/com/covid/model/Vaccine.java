package com.covid.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vaccineId;
	
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String vaccineName;
	
	
	@NotNull
	private String description;
	
	

    @JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "vaccine")
	private VaccineCount vaccineCount;

	
	// @JsonIgnore
	// @OneToOne(cascade = CascadeType.ALL,mappedBy = "vaccine")
	// private Member member;
}