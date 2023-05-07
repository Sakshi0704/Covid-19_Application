package com.covid.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    //@JsonIgnore
    @OneToMany
    private List<Appointment> appointmentList = new ArrayList<>();
    
   // @JsonIgnore
    @OneToMany
    private List<VaccineInventory> vaccineInventoryList;


    
}