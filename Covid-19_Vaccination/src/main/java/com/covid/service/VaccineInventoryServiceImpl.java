// package com.covid.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.covid.exception.VaccinationCenterException;
// import com.covid.exception.VaccineException;
// import com.covid.exception.VaccineInventoryException;
// import com.covid.model.VaccinationCentre;
// import com.covid.model.Vaccine;
// import com.covid.model.VaccineCount;
// import com.covid.model.VaccineInventory;
// import com.covid.repository.VaccinationCentreRepository;
// import com.covid.repository.VaccineInventoryRepository;
// import com.covid.repository.VaccineRepository;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;



// @Service
// public class VaccineInventoryServiceImpl implements VaccineInventoryService {

// 	@Autowired
// 	private VaccineInventoryRepository vaccineInventoryRepository;
	
// 	@Autowired
// 	private VaccinationCentreRepository vaccinationCentreRepository;
	
// 	@Autowired
// 	private VaccineRepository vaccineRepository;
	
	
// 	@Override
// 	public List<VaccineInventory> allVaccineInventory() throws VaccineInventoryException {
		
// 		List<VaccineInventory> vaccineInventoryList = vaccineInventoryRepository.findAll();
		
// 		if(vaccineInventoryList.isEmpty()) {
// 			throw new VaccineInventoryException("No Vaccine Found");
// 		}
		
// 		return vaccineInventoryList;
// 	}

// 	// @Override
// 	// public VaccineInventory getVaccineInventoryByCenter(Long centerId) throws VaccineInventoryException, VaccinationCenterException {
			
		
// 	// 	Optional<VaccinationCentre> vaccinationCenter = vaccinationCentreRepository.findById(centerId);
		
// 	// 	if(vaccinationCenter.isPresent()) {
// 	// 		return vaccinationCenter.get().getVaccineInventory();
// 	// 	}else {
// 	// 		throw new VaccinationCenterException("No Vaccination Center Found with centerId: "+centerId);
// 	// 	}

// 	// }

// 	@Override
// 	public VaccineInventory addVaccineCount(Integer vaccineInventoryId, Integer vaccineId, VaccineCount vaccineCount) throws VaccineInventoryException,VaccineException {
		
// 		VaccineInventory vaccineInventory = vaccineInventoryRepository.findById(vaccineInventoryId)
// 				.orElseThrow(() -> new VaccineInventoryException("VaccineInventory does not exits"));
		
// 		Vaccine vaccine = vaccineRepository.findById(vaccineId).orElseThrow(() -> new VaccineException("Vaccine does not exist"));
		
// 			vaccine.setVaccineCount(vaccineCount);
		
		
// 		return vaccineInventory;
// 	}

// 	// @Override
// 	// public VaccineInventory updateVaccineInventory(Integer vaccineInventoryId , VaccineInventory vaccineInventory) throws VaccineInventoryException {
			
// 	// 	VaccineInventory existingVaccineInventory = vaccineInventoryRepository.findById(vaccineInventoryId)
// 	// 			.orElseThrow(() -> new VaccineInventoryException("No VaccineInventory fond with id: "+ vaccineInventoryId));
		
		
// 	// 	List<VaccinationCentre> vaccinationCentersList =  existingVaccineInventory.getVaccinationCenters();
		
// 	// 	for(VaccinationCentre vaccinaCenters : vaccinationCentersList) {
// 	// 		vaccinaCenters.setVaccineInventory(vaccineInventory);
// 	// 	}
		
// 	// 	List<VaccineCount> VaccineCountList = vaccineInventory.getVaccineCounts();
		
// 	// 	for(VaccineCount vaccineCount: VaccineCountList) {
// 	// 		vaccineCount.setVaccineInventory(vaccineInventory);
// 	// 	}
		
// 	// 	return vaccineInventoryRepository.save(vaccineInventory);
// 	// }

// 	@Override
// 	public Boolean deleteVaccineInventory(Integer vaccineInventoryId) throws VaccineInventoryException {
		
// 		VaccineInventory vaccineInventory =  vaccineInventoryRepository.findById(vaccineInventoryId).orElseThrow(() -> new VaccineInventoryException("No VaccineInventory found with id: "+vaccineInventoryId));
		
// 		vaccineInventoryRepository.deleteById(vaccineInventoryId);
		
// 		return true;
// 	}

// 	@Override
// 	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date) throws VaccineInventoryException {

// 		List<VaccineInventory> list = vaccineInventoryRepository.findByDate(date);
		
// 		if(list.isEmpty()) {
// 			throw new VaccineInventoryException("No VaccineInventory Found with date :"+date);
// 		}
// 		return list;
// 	}

// 	@Override
// 	public List<VaccineInventory> getVaccineInventoryByVaccine(Vaccine vaccine) throws VaccineInventoryException {
		
// 		List<VaccineInventory> result = new ArrayList<>();
		
// 		List<VaccineInventory> list = vaccineInventoryRepository.findAll();
		
// 		if(list.isEmpty()) {
// 			throw new VaccineInventoryException("No VaccineInventory found, Please add some inventory first");
// 		}
		
// 		for(VaccineInventory vacInv: list) {
// 			List<VaccineCount> vacCountList = vacInv.getVaccineCounts();
			
// 			if(vacCountList.isEmpty()) {
// 				throw new VaccineInventoryException("No Vaccine Quentity found, Please add some Vaccine Quentity");
// 			}
			
// 			for(VaccineCount vacCount: vacCountList) {
// 				if(vacCount.getVaccine()==vaccine) {
// 					result.add(vacInv);
// 				}
// 			}
// 		}
// 		if(result.isEmpty()) {
// 			throw new VaccineInventoryException("No VaccineInventory Found with Vaccine: "+vaccine);
// 		}
// 		return result;
		
// 	}

// }
