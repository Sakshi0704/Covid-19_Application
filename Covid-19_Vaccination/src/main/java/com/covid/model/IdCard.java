package com.covid.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer Id;
	
	// @NotBlank(message = "Name should not be blank")
	// @NotEmpty(message = "")
	// @NotNull
	// @Size(min = 2, max = 25)
	private String name;
	
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	//@Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}")
	private String dateOfBirth;
	
	// @Enumerated(EnumType.STRING)
	 private String gender;

//	private String mobile;
	
	private String locality;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	// @JsonIgnore
	// @OneToOne
	// @JoinColumn(name = "member_id")
	// private Member member;
	
	//@JsonIgnore
	
	@OneToOne(cascade= CascadeType.ALL)
	private IdProof idProof ;


	@ManyToOne(cascade = CascadeType.ALL)
	private MainUser mainuser;
	
}
