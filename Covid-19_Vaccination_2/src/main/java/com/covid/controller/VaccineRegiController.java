package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.exception.MemberException;
import com.covid.exception.VaccineRegistrationException;
import com.covid.model.Member;
import com.covid.model.VaccineRegistration;
import com.covid.service.VaccineRegistrationService;
import com.covid.service.VaccineRegistrationServiceImpl;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/covid")
public class VaccineRegiController {

	@Autowired
	private VaccineRegistrationService vaccineRegistrationService;
	
	@GetMapping("/veregistrations")
	public ResponseEntity<List<VaccineRegistration>> getAllVaccineRegistrationsHandler() throws VaccineRegistrationException{
		
		  List<VaccineRegistration> vaccineRegistrationsList =  vaccineRegistrationService.getAllVaccineRegistrations();
		  
		  return new ResponseEntity<>(vaccineRegistrationsList,HttpStatus.FOUND);
		
	}
	
	
	@GetMapping("/vresgitration/{mobileNo}")
	 public ResponseEntity<VaccineRegistration> getVaccineRegistrationHandler(@PathVariable String mobileNo) throws VaccineRegistrationException{
		
		
		//System.out.println(mobileNo);
		VaccineRegistration vaccineRegistration = vaccineRegistrationService.getVaccineRegistration(mobileNo);
		
		return new ResponseEntity<>(vaccineRegistration,HttpStatus.OK);
		
	 }
	
	
	@PostMapping("/vaccineRegis")
	 public ResponseEntity<VaccineRegistration> addVaccineRegistrationHandler(@Valid @RequestBody VaccineRegistration vaccineRegistration) throws VaccineRegistrationException{
		 
		System.out.println(vaccineRegistration.getMobile());
		System.out.println(vaccineRegistration.getDateOfRegistration());
		
		 VaccineRegistration saveVaccineRegistration = vaccineRegistrationService.addVaccineRegistration(vaccineRegistration);
		 
		 return new ResponseEntity<>(saveVaccineRegistration,HttpStatus.CREATED);
		 
	 }
	
	
	 @GetMapping("/vmembers/{mobileNo}")
	  public ResponseEntity<List<Member>> getAllMemberByMobileHandler(@PathVariable String mobileNo) throws VaccineRegistrationException, MemberException{
		
		List<Member> members = vaccineRegistrationService.getAllMemberByMobile(mobileNo);
	
		
		return new ResponseEntity<>(members,HttpStatus.FOUND);
		
	 }
	
	 
	 @PostMapping("/vmembers/{mobileNo}")
	 public ResponseEntity<List<Member>> addMemberThroughMobileNoHandler( @PathVariable String mobileNo , @Valid @RequestBody Member member) throws VaccineRegistrationException, MemberException{
		 
		 		List<Member> members =  vaccineRegistrationService.addMemberThroughMobileNo(member, mobileNo);
		 		
		 		return new ResponseEntity<List<Member>>(members, HttpStatus.ACCEPTED);
		 
	 }
	
	
	
}
