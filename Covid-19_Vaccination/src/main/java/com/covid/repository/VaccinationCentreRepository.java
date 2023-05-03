package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.entities.VaccinationCentre;

public interface VaccinationCentreRepository extends JpaRepository<VaccinationCentre,Long>{
    
}