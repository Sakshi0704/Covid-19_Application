package com.covid.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingid;

	// DOUBT STRING OR LONG
	//	@Pattern(regexp = "[7-9]{1}[0-9]{9}", message = "Please Enter a Valid Mobile Number")
	//	private String mobileno;


	//@NotEmpty
	private LocalDate dateofbooking;

	// @NotNull
	// @NotEmpty
	@Enumerated(EnumType.STRING)
	private Slot slot;
	
	private LocalDate appointmentDate;

	private boolean bookingstatus;  // true -- false
	
	
	@ManyToOne
	private IdCard idcardNo; //referId 
	
//	@JsonIgnore
//	@OneToOne
//    private Member member;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private VaccinationCentre vaccinationCentre;


}
