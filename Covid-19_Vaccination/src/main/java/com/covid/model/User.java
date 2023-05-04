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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.*;


@Data
@Getter
@Setter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer UserId;
	
	@NotEmpty
	@NotNull
	@Column(unique = true)
	private String UserMobile;
	
	@NotEmpty
	@NotNull
	private String UserName;
	
	
	private String UserPassword;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private Set<IdCard> setIdCard = new HashSet<>();
	
	
	
	
}
