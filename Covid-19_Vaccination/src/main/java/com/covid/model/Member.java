package com.covid.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberId;
	
	private Boolean dose1Status;
	
	private Boolean dose2Status;
	
	private LocalDate dose1Date;
	
	private LocalDate dose2Date;
	
	
	@OneToOne
	private IdCard idCard;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<VaccineRegistration> vaccineRegistrationList;
	
	
	@OneToOne
	private Vaccine vaccine;
	
	
	@OneToOne
	private Appointment appointment;
	
}
