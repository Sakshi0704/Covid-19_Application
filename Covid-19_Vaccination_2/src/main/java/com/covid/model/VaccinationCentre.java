package com.covid.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "VaccinationCENTRE")
public class VaccinationCentre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vaccineId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "vaccinationCentre")
    private List<Appointment> appointmentList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    //private List<VaccineInventory> vaccineInventoryList = new ArrayList<>();
    private VaccineInventory vaccineInventory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccinationCentre")
    private List<VaccineCount> vaccineCountList;


}
