package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.VaccinationCentre;

@Repository
public interface VaccinationCentreRepository extends JpaRepository<VaccinationCentre,Long>{
   // public VaccinationCentre findbyCentreId(Long centreId );
}