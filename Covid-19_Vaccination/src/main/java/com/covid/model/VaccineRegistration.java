package com.covid.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class VaccineRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer VaccineRegistrationId;

	
	@NotNull(message = "Mobile is not null, is Mandatory")
	@NotBlank(message = "Mobile is Mandatory")
	private String mobileNo;
	private LocalDate dateOfRegistration;

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Member member;

	
	
}
