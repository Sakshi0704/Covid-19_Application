package com.covid.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
}