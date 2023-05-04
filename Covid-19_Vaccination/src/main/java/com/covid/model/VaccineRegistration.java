package com.covid.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class VaccineRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer VaccineRegistrationId;

	
	private String mobileNo;
	private LocalDate dateOfRegistration;

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Member member;

	
	
}
