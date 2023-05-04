package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.covid.model.VaccineCount;

@Repository
public interface VaccineCountRepository extends JpaRepository<VaccineCount,Integer> , PagingAndSortingRepository<VaccineCount, Integer>  {

	
	
}
