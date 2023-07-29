package com.covid.model;

import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "APPOINTMENT")
public class Appointment {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Member member;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private VaccinationCentre vaccinationCentre;

    private LocalDate dateofbooking = LocalDate.now();

    private LocalDate dateofappointment;

    private Slot slot;

    private boolean bookingStatus = false;

    private boolean appointmentStatus = false;

}
