package com.covid.model;




import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;



public class AdharCard {
	
	
	@Pattern(regexp = "[0-9]{12}")
	@NotNull
	private Long adharNumber;

	
}
