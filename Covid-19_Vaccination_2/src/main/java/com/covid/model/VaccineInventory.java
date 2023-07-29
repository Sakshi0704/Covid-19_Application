package com.covid.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "VACCINEINVENTORY")
public class VaccineInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaccineInventoryId;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "vaccineInventory")
    private List<VaccinationCentre> vaccinationCentreList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "VACCINECOUNTID")
    private VaccineCount vaccineCount;

    private LocalDate date;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "vaccineInventory")
//    @JoinColumn(name = "VACCINEINVENTORY_ID")
//    private List<Vaccine> vaccineList;         no relaation
}
