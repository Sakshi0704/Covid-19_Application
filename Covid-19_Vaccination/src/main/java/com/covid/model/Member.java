// package com.covid.model;

// import java.time.LocalDate;
// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonFormat;
// import com.fasterxml.jackson.annotation.JsonIgnore;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Entity
// public class Member{
	
// 	@Id
// 	@GeneratedValue(strategy = GenerationType.AUTO)
// 	private Integer memberId;
	
// 	private Boolean dose1Status;
	
// 	private Boolean dose2Status;
	
// 	//@JsonFormat(shape= JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd")
// 	private LocalDate dose1Date;
	
// 	//@JsonFormat(shape= JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd")
// 	private LocalDate dose2Date;
	
	
// 	// @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
// 	// @JoinColumn(name = "IdCard_id")
// 	// private IdCard idCard;
	
// 	//@JsonIgnore
// 	@ManyToMany(cascade = CascadeType.PERSIST)
// 	private VaccineRegistration vaccineRegistration;
	
	
// 	// @OneToOne(cascade = CascadeType.PERSIST)
// 	// private Vaccine vaccine;
	
	
// 	@OneToOne
// 	private Appointment appointment;
	
// }


package com.covid.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	
	
	private Boolean dose1Status;
	
	
	private Boolean dose2Status;
	
	
	private LocalDate dose1Date;
	

	
	private LocalDate dose2Date;
	
	
	// @OneToOne(mappedBy = "member")
	// private IdCard idCard;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<VaccineRegistration> vaccineRegistrationList;
	
	
	// @OneToOne
	// private Vaccine vaccine;
	
	
	@OneToOne
	private Appointment appointment;
	
}




