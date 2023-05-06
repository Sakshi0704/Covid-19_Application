package com.covid.service;

import java.util.List;

import com.covid.exception.MemberException;
import com.covid.exception.VaccineRegistrationException;
import com.covid.model.Member;
import com.covid.model.VaccineRegistration;

public interface VaccineRegistrationService {

	public VaccineRegistration addVaccineRegistration(VaccineRegistration vaccineRegistration);
	
	public List<VaccineRegistration> getAllVaccineRegistration() throws VaccineRegistrationException;
	
	public VaccineRegistration getVaccineRegistration(String mobileNo) throws VaccineRegistrationException;
	
	public List<Member> getAllMemberByMobile(String mobileNo) throws VaccineRegistrationException,MemberException;

	
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration vaccineRegistration) throws VaccineRegistrationException;
	
	
	public Boolean deleteVaccineRegistration(VaccineRegistration vaccineRegistration) throws VaccineRegistrationException;
	
}
