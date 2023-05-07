package com.covid.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingid;

	// DOUBT STRING OR LONG
	@Pattern(regexp = "[7-9]{1}[0-9]{9}", message = "Please Enter a Valid Mobile Number")
	private String mobileno;


	//@NotEmpty
	private String dateofbooking;

	// @NotNull
	// @NotEmpty
	@Enumerated(EnumType.STRING)
	private Slot slot;

	// @OneToOne(cascade = CascadeType.ALL)
	// private VaccinationCenter vaccinationcenter

	private boolean bookingstatus;
	
	// @OneToOne
	// private Member member;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private VaccinationCentre vaccinationCentre;


	
}
