package com.covid.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "VaccinE")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaccineId;

    private String vaccineName;

    private String description;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private VaccineCount VaccineCount;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vaccine")
    private VaccineCount vaccineCount;
}
