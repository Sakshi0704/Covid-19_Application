package com.covid.model;

import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MainUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	// @NotEmpty
	// @NotNull
	// @Pattern(regexp = "[0-9]{10}")
	//@Column(unique = true, length=10)
	private String userMobile;

	private Integer otp;
	
	
	
	// @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private Set<IdCard> idCardSet = new HashSet<>();
	
	
	
	
}
