package com.covid.service;

import java.time.LocalDate;
import java.util.List;

import com.covid.exception.VaccinationCenterException;
import com.covid.exception.VaccineException;
import com.covid.exception.VaccineInventoryException;
import com.covid.model.Vaccine;
import com.covid.model.VaccineCount;
import com.covid.model.VaccineInventory;


public interface VaccineInventoryService {

	public List<VaccineInventory> allVaccineInventory() throws VaccineInventoryException;  //admin // asc by date
	
	public VaccineInventory getVaccineInventoryByCenter(Long centerId) throws VaccineInventoryException, VaccinationCenterException;
	
	public VaccineInventory  addVaccineCount(Integer vaccineInventoryId, Integer vaccineId, VaccineCount vaccineCount) throws VaccineInventoryException,VaccineException;
	
	public VaccineInventory updateVaccineInventory(Integer vaccineInventoryId , VaccineInventory vaccineInventory) throws VaccineInventoryException;
	
	public Boolean deleteVaccineInventory(Integer vaccineInventoryId) throws VaccineInventoryException;
	
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date) throws VaccineInventoryException;
	
	public List<VaccineInventory> getVaccineInventoryByVaccine(Vaccine vaccine) throws VaccineInventoryException;
	
	 
}
