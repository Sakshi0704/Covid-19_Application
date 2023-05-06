package com.covid.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Data
public class VaccineRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer VaccineRegistrationId;

	
	@NotNull(message = "Mobile is not null, is Mandatory")
	@NotBlank(message = "Mobile is Mandatory")
	@Column(nullable = true,unique = true)
	private String mobileNo;
	
	@JsonFormat(pattern = "yyyy-MM-dddd")
	@NotNull
	private LocalDate dateOfRegistration;

	
	@OneToMany(cascade = CascadeType.PERSIST , mappedBy = "vaccineRegistration")
	private List<Member> memberList = new ArrayList<>();

}
