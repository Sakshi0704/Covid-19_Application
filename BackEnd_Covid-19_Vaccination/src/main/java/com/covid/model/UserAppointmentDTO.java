package com.covid.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.Setter;


@Data
public class UserAppointmentDTO {

	private Integer refId; //IdCard
	private Integer vaccineId;  //vacc
	
	private Long centreId; 
	private LocalDate dateOfBooking = LocalDate.now();
	private LocalDate dateOfAppointment;
	
	private Slot slot;
	
}
