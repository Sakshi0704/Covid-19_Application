package com.covid.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

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
    

    @OneToMany
    private List<Appointment> appointmentList = new ArrayList<>();


    
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private VaccineInventory vaccineInventory;
    
}