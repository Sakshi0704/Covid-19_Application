package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.model.VaccinationCentre;

public interface VaccinationCentreRepository extends JpaRepository<VaccinationCentre,Long>{
    
}