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
import jakarta.persistence.OneToOne;
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
@Data
public class VaccineRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer VaccineRegistrationId;

	
	// @NotNull(message = "Mobile is not null, is Mandatory")
	// @NotBlank(message = "Mobile is Mandatory")
	// @Column(nullable = true,unique = true)
	private String mobileNo;
	
	// @JsonFormat(pattern = "yyyy-MM-dddd")
	// @NotNull
	private LocalDate dateOfRegistration;

	@OneToOne(cascade = CascadeType.ALL)
	private Appointment appointmnet;
	
	// @OneToMany(cascade = CascadeType.PERSIST)
	// private List<Member> memberList = new ArrayList<>();

	

}


// package com.covid.model;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Embedded;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
// import jakarta.validation.constraints.NotNull;


// @Entity
// public class VaccineRegistration {

// 	@Id
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	private Integer VaccineRegistrationId;

	
// 	private String mobileNo;
// 	private LocalDate dateOfRegistration;

	
// 	@ManyToMany(cascade = CascadeType.PERSIST)
// 	List<Member> memberList;

	
	
// }
