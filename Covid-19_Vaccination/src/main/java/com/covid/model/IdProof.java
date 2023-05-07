package com.covid.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdProof {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    
    private String idName;
    
    private String idNumber;
    
}