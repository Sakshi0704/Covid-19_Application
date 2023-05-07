// package com.covid.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;

// import com.covid.exception.IdCardException;
// import com.covid.exception.MemberException;
// import com.covid.model.Member;
// import com.covid.repository.MemberRepository;

// public class MemberServiceImpl implements MemberService {

// 	@Autowired
// 	private MemberRepository memberRepo;

// 	@Override
// 	public List<Member> getAllMembers() throws MemberException {
// 		// TODO Auto-generated method stub
// 		List<Member> memberList = memberRepo.findAll();

// 		if (memberList.isEmpty())
// 			throw new MemberException("No Member Found");

// 		return memberList;
// 	}

// 	@Override
// 	public Member getMemberById(Integer memberId) throws MemberException {
// 		// TODO Auto-generated method stub
// 		Optional<Member> member = memberRepo.findById(memberId);
		
// 		if(member.isPresent() == false) throw new MemberException("Member not found");

// 		return member.get();

// 	}

// 	@Override
// 	public Member getMemberByAdharNo(Long adharNumber) throws MemberException {
// 		// TODO Auto-generated method stub
// 		Member member = memberRepo.findMemberByAdharNumber(adharNumber);
		
// 		if(member == null) throw new MemberException("Member Not Found");
		
// 		return member;
// 	}

// 	@Override
// 	public Member addMember(Member member) throws MemberException, IdCardException {
// 		// TODO Auto-generated method stub
		
// 		if(member.getIdCard() == null) throw new IdCardException("provide IdCard information first");
		
// 		if(memberRepo.findMemberByAdharNumber(member.getIdCard().getAdharCard().getAdharNumber()) != null) {
// 			throw new MemberException("Member with same Adhar Number already exists");
// 		}
		
// 		/*
// 		 * if member enters his idcard details and save it then the member will be automatically created
// 		 */
		
// 		return member;
// 	}
	
	

// 	/*
// 	 * To access this method 
// 	 * frontend developer should provide the memberId also
// 	 * 
// 	 * from frontend we can save the memberId in local storage when a user enters into the member's dashboard
// 	 * and when he will be leaving member's dashboard then we have to remove memberId from local storage
// 	 */
// 	@Override
// 	public Member updateMember(Member member) throws MemberException, IdCardException {
// 		// TODO Auto-generated method stub
		
// 		if(member.getIdCard() == null) throw new IdCardException("provide IdCard information first");
		
// 		/*
// 		 * checking for the member is already registered or not 
// 		 * if not then throwing an exception with message "register first"
// 		 */
// 		if(memberRepo.findMemberByAdharNumber(member.getIdCard().getAdharCard().getAdharNumber()) == null) {
// 			throw new MemberException("Member with Adhar Number doesn't exists, Please try to register first!!!");
// 		}
		
		
// 		Optional<Member> op = memberRepo.findById(member.getMemberId());
		
// 		if(op.isPresent() == false) {
// 			throw new MemberException("Member not found");
// 		}
		
// 		Member existingMember = op.get();
		
// 		existingMember.setDose1Status(member.getDose1Status());
// 		existingMember.setDose2Status(member.getDose2Status());
// 		existingMember.setDose1Date(member.getDose1Date());
// 		existingMember.setDose2Date(member.getDose2Date());
		
// 		return memberRepo.save(existingMember);
// 	}

// 	@Override
// 	public Boolean deleteMember(Member member) throws MemberException {
// 		// TODO Auto-generated method stub
// 		return null;
// 	}

// }



package com.covid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.covid.model.Member;
import com.covid.repository.MemberRepository;

public class MemberServiceImpl implements MemberService{


    @Autowired
	private MemberRepository memberRepository;

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> getMemberById(Integer id) {
        return memberRepository.findById(id);
    }

    @Override
    public void deleteMember(Integer id) {
        memberRepository.deleteById(id);
    }

    // @Override
    // public void updateMember(Integer id, Member member) {
    //     Optional<Member> optionalMember = memberRepository.findById(id);
	// 	if (optionalMember.isPresent()) {
	// 		Member existingMember = optionalMember.get();
	// 		existingMember.setDose1Status(member.getDose1Status());
	// 		existingMember.setDose2Status(member.getDose2Status());
	// 		existingMember.setDose1Date(member.getDose1Date());
	// 		existingMember.setDose2Date(member.getDose2Date());
	// 		existingMember.setIdCard(member.getIdCard());
	// 		existingMember.setVaccineRegistrationList(member.getVaccineRegistrationList());
	// 		existingMember.setVaccine(member.getVaccine());
	// 		existingMember.setAppointment(member.getAppointment());
	// 		memberRepository.save(existingMember);
	// 	}
    // }
    
}