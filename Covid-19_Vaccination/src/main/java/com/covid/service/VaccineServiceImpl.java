package com.covid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.exception.VaccineException;
import com.covid.model.Vaccine;
import com.covid.model.VaccineCount;
import com.covid.repository.VaccineRepository;
import java.util.List;
import java.util.Optional;



@Service
public class VaccineServiceImpl implements VaccineService {

	
	@Autowired
	private VaccineRepository vaccineRepository;

	
	
	@Override
	public List<Vaccine> getAllService() throws VaccineException {
		
		List<Vaccine> vaccineList = vaccineRepository.findAll();
		
		if(vaccineList.isEmpty()) {
			throw new VaccineException("No Vaccine avaiable");
		}
		
		return vaccineList;
		
	}
	
	
	@Override
	public Vaccine getVaccineByName(String vaccineName) throws VaccineException{
		
		 Optional<Vaccine> vaccine =  vaccineRepository.findByVaccineName(vaccineName);
		 
		 	if(vaccine.isPresent()) {
		 		 return vaccine.get();
		 	}
		 
		 	throw new VaccineException("No Vaccine avaiable");
		
	}


	@Override
	public Vaccine getVaccineById(Integer vaccineId) throws VaccineException {
		
		Optional<Vaccine> vaccine =  vaccineRepository.findById(vaccineId);
		 
	 	if(vaccine.isPresent()) {
	 		 return vaccine.get();
	 	}
	 
	 	throw new VaccineException("No Vaccine avaiable");
	}


	@Override
	public Vaccine registerNewVaccine(Vaccine vaccine) throws VaccineException {
		
			Vaccine existingVaccine = vaccineRepository.findByVaccineName(vaccine.getVaccineName())
					.orElseThrow(() -> new VaccineException("Vaccine already exist"));
			
			
			VaccineCount vaccineCount = vaccine.getVaccineCount();
			
			vaccineCount.setVaccine(vaccine);
			
			return vaccineRepository.save(vaccine);
			
	}
	
	
	
	@Override
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineException {
		
		Vaccine existingVaccine = vaccineRepository.findById(vaccine.getVaccineId())
				.orElseThrow(() -> new VaccineException("Vaccine does not exist"));

	   return vaccineRepository.save(vaccine);
		
	}

	
	
	@Override
	public Vaccine deleteVaccine(Vaccine vaccine) throws VaccineException {
		
		Vaccine existingVaccine = vaccineRepository.findById(vaccine.getVaccineId())
				.orElseThrow(() -> new VaccineException("Vaccine does not exist"));
		

		return vaccineRepository.save(vaccine);
	
	}
	
	
}
