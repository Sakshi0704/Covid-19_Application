package com.covid.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.covid.exception.VaccineInventoryException;
import com.covid.model.VaccineInventory;

@Repository
public interface VaccineInventoryRepository extends JpaRepository<VaccineInventory, Integer> , PagingAndSortingRepository<VaccineInventory, Integer> {

	public List<VaccineInventory> findByDate(LocalDate date) throws VaccineInventoryException;

}
