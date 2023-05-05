package com.covid.model;

import java.time.LocalDate;



import jakarta.persistence.Entity;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingid;

	// DOUBT STRING OR LONG
	@Pattern(regexp = "[7-9]{1}[0-9]{9}", message = "Please Enter a Valid Mobile Number")
	private long mobileno;

	@NotNull
	@NotEmpty
	private LocalDate dateofbooking;

	@NotNull(message = "Null value is not applicable")
	@NotEmpty(message = "Slot details are necessary")
	private Slot slot;

	// @OneToOne(cascade = CascadeType.ALL)
	// private VaccinationCenter vaccinationcenter

	private boolean bookingstatus;
	
	@OneToOne
	private Member member;
	
	
	@OneToOne
	private VaccinationCentre vaccinationCentre;


	
}
