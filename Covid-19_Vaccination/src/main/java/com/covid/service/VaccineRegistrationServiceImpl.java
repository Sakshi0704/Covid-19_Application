package com.covid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.exception.MemberException;
import com.covid.exception.VaccineRegistrationException;
import com.covid.model.Member;
import com.covid.model.VaccineRegistration;
import com.covid.repository.VaccineRegistrationRepository;


@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService{

	@Autowired
	private VaccineRegistrationRepository vaccineRegistrationRepository;
	
	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration vaccineRegistration) {
			
			List<Member> memberList = vaccineRegistration.getMemberList();
		
			memberList.forEach((m) -> m.setVaccineRegistration(vaccineRegistration));
			
			
		return vaccineRegistrationRepository.save(vaccineRegistration) ;
	}

	@Override
	public List<VaccineRegistration> getAllVaccineRegistration() throws VaccineRegistrationException {
	
			List<VaccineRegistration> list = vaccineRegistrationRepository.findAll();
			
			if(list.isEmpty()) {
				throw new VaccineRegistrationException("No Data available");
			}
		
		return list;
	}

	@Override
	public VaccineRegistration getVaccineRegistration(String mobileNo) throws VaccineRegistrationException {
		
		
			VaccineRegistration vaccineRegistration = vaccineRegistrationRepository.findByMobileNo(mobileNo);
			
			if(vaccineRegistration == null) {
				throw new VaccineRegistrationException("No Vaccine Registration available");
			}
			
			
		return vaccineRegistration;
	}



	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration vaccineRegistration)
			throws VaccineRegistrationException {
	
		
		Optional<VaccineRegistration> existingVaccineReg = vaccineRegistrationRepository.findById(vaccineRegistration.getVaccineRegistrationId());
		
		if(existingVaccineReg.isPresent()) {
		
			return vaccineRegistrationRepository.save(vaccineRegistration);
		}
		else {
			throw new VaccineRegistrationException("No Registered member with details: "+vaccineRegistration);
		}
	
	}

	@Override
	public Boolean deleteVaccineRegistration(VaccineRegistration vaccineRegistration)
			throws VaccineRegistrationException {
		
	   Optional<VaccineRegistration> existingVaccineReg = vaccineRegistrationRepository.findById(vaccineRegistration.getVaccineRegistrationId());
		
		if(existingVaccineReg.isPresent()) {
			vaccineRegistrationRepository.delete(vaccineRegistration);
			return true;
		}else {
			throw new VaccineRegistrationException("No Data Found with the registration: "+vaccineRegistration);
		}
	}

	@Override
	public List<Member> getAllMemberByMobile(String mobileNo) throws VaccineRegistrationException, MemberException {
		
		VaccineRegistration	existingVaccineReg = vaccineRegistrationRepository.findByMobileNo(mobileNo);
		if(existingVaccineReg==null) {
			throw new VaccineRegistrationException("No Registration found with mobileNo "+mobileNo);
		}
		
		List<Member> members = existingVaccineReg.getMemberList();
		
		if(members==null) {
			throw new VaccineRegistrationException("No Member Registration for vaccine with : "+mobileNo);
		}
		return members;
	}

}
