package com.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdharCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adharCardId;
	
	@Pattern(regexp = "[0-9]{12}")
	private Long adharNumber;
	
	
	@JsonIgnore
	@OneToOne(mappedBy = "adharCard", cascade = CascadeType.ALL)
	private IdCard idCard;
	
}
