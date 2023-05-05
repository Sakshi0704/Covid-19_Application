package com.covid.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VaccinationCentre {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long centreId;
    private String state;
    private String city;
    private String pincode;
    private String locality;
    
    @OneToMany
    private List<Appointment> appointmentList = new ArrayList<>();
    
    @OneToMany
    private List<VaccineInventory> vaccineInventoryList;
    
}