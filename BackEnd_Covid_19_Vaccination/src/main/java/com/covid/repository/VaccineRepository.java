package com.covid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine,Integer> {

		public Vaccine findByVaccineName(String vaccineName);
	
}
