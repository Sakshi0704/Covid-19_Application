
package com.covid.service;

 import java.time.LocalDate;
import java.util.List;


 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import com.covid.exception.MemberException;
 import com.covid.exception.VaccineRegistrationException;
 import com.covid.model.Member;
 import com.covid.model.VaccineRegistration;
import com.covid.repository.MemberRepository;
import com.covid.repository.VaccineRegistrationRepository;

@Service
 public class VaccineRegistrationServiceImpl implements VaccineRegistrationService{

 	@Autowired
 	private VaccineRegistrationRepository vaccineRegistrationRepository;
 	
// 	@Autowired
// 	private MemberRepository memberRepository;
	
 	
 	// user...
	@Override 
	public VaccineRegistration addVaccineRegistration(VaccineRegistration vaccineRegistration) throws VaccineRegistrationException {
		
 	 	return vaccineRegistrationRepository.save(vaccineRegistration) ;
 	 	
 	 }

	
	
	// admin...
 	@Override
 	 public List<VaccineRegistration> getAllVaccineRegistrations() throws VaccineRegistrationException {
	
 			List<VaccineRegistration> list = vaccineRegistrationRepository.findAll();
			
 			if(list.isEmpty()) {
 				throw new VaccineRegistrationException("No Data available");
 			}
		
 		return list;
 	}

 	
 	
 	@Override
 	public VaccineRegistration getVaccineRegistration(String mobileNo) throws VaccineRegistrationException {
		
		
 			VaccineRegistration vaccineRegistration = vaccineRegistrationRepository.findByMobile(mobileNo);
			
 			if(vaccineRegistration == null) {
 				throw new VaccineRegistrationException("No Vaccine Registration available");
 			}
			
 			
			
 		return vaccineRegistration;
 	}


 	@Override
 	public List<Member> getAllMemberByMobile(String mobileNo) throws VaccineRegistrationException, MemberException {
		
 		VaccineRegistration	existingVaccineReg = vaccineRegistrationRepository.findByMobile(mobileNo);
 		if(existingVaccineReg==null) {
 			throw new VaccineRegistrationException("No Registration found with mobileNo "+mobileNo);
 		}
		
 		List<Member> members = existingVaccineReg.getMembers();
 		//List<Member> members=null;
 		if(members==null || members.size()==0){
 			throw new VaccineRegistrationException("No Member Registration for vaccine with : "+mobileNo);
 		}
 		return members;
 	}



	@Override
	public List<Member> addMemberThroughMobileNo(Member member, String mobileNo)
			throws VaccineRegistrationException, MemberException {
		
		VaccineRegistration preVaccineReg = vaccineRegistrationRepository.findByMobile(mobileNo);
		
		if(preVaccineReg!=null) {
			preVaccineReg.getMembers().add(member);
			
			vaccineRegistrationRepository.save(preVaccineReg);
			//memberRepository.save(member);
			return preVaccineReg.getMembers();
			
		}else {
			
			VaccineRegistration vaccineRegistration = new VaccineRegistration();
			vaccineRegistration.setMobile(mobileNo);
			vaccineRegistration.setDateOfRegistration(LocalDate.now());
			
			vaccineRegistration.getMembers().add(member);
			
			vaccineRegistrationRepository.save(vaccineRegistration);
			return vaccineRegistration.getMembers();
		}
	
	}

 }
 