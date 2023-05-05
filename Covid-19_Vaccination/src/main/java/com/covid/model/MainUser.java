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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotEmpty
	@NotNull
	@Column(unique = true)
	private String userMobile;
	
	@NotEmpty
	@NotNull
	private String userName;
	
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", 
			message = "password should contain 8 characters including at least one number and one alphabet")
	private String userPassword;
	
	
//	@JsonIgnore
	@OneToMany(mappedBy = "mainUser", cascade = CascadeType.ALL)
	private Set<IdCard> idCardSet = new HashSet<>();
	
	
	
	
}
