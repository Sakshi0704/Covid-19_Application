package com.covid.model;

import lombok.Getter;
import lombok.Setter;



import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Getter
@Setter
@Table(name = "MEMBER")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberId;
	
	@Column(columnDefinition = "false")
	private boolean dose1Status=false;
	
	@Column(columnDefinition = "false")
	private boolean dose2Status=false;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@FutureOrPresent
	private LocalDate dose1Date;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@FutureOrPresent
	private LocalDate dose2Date;

	
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private VaccineRegistration vaccineRegistration;

    
 //   @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private IdCard idCard;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "member")
    private List<Appointment> appointmentList = new ArrayList<>();

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "blockedId")
    private BlockedAppointments blockedAppointments;


    @JsonIgnore
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "vaccineId")
    private Vaccine vaccine;


//	public Member() {
//		this.dose1Date = null;
//		this.dose1Status = false;
//		this.dose2Date = null;
//		this.dose2Status = false;
//	}
  

}
