package com.covid.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private Boolean dose1Status;
	private Boolean dose2Status;
	private LocalDate dose1Date;
	private LocalDate dose2Date;
}
