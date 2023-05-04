package com.covid.service;

import java.util.List;

import com.covid.exception.VaccineException;
import com.covid.model.Vaccine;

public interface VaccineService {

	
	public List<Vaccine> getAllService() throws VaccineException;
	
	
	public Vaccine getVaccineByName(String vaccineName) throws VaccineException;
	
	
	public Vaccine getVaccineById(Integer vaccineId) throws VaccineException;
	
	
	public Vaccine registerNewVaccine(Vaccine Vaccine)throws VaccineException;
	
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineException ;
	
	public Vaccine deleteVaccine(Vaccine vaccine) throws VaccineException;
	 
}
