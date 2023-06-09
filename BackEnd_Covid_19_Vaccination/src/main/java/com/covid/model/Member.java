package com.covid.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	
	private boolean dose1Status;
	
	private boolean dose2Status;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd")
	private LocalDate dose1Date;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd")
	private LocalDate dose2Date;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IdProof_id")
	private IdProof idProof;
	
	//@JsonIgnore
	// @ManyToMany(cascade = CascadeType.PERSIST)
	// private VaccineRegistration vaccineRegistration;
	
	
	// @OneToOne(cascade = CascadeType.PERSIST)
	// private Vaccine vaccine;
	
	
	@OneToOne
	private Appointment appointment;
	
}





	





