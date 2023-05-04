package com.covid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.covid.exception.MemberException;
import com.covid.model.Member;
import com.covid.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepo;

	@Override
	public List<Member> getAllMembers() throws MemberException {
		// TODO Auto-generated method stub
		List<Member> memberList = memberRepo.findAll();

		if (memberList.isEmpty())
			throw new MemberException("No Member Found");

		return memberList;
	}

	@Override
	public Member getMemberById(Integer memberId) throws MemberException {
		// TODO Auto-generated method stub
		Optional<Member> member = memberRepo.findById(memberId);
		
		if(member.isPresent() == false) throw new MemberException("Member not found");

		return member.get();

	}

	@Override
	public Member getMemberByAdharNo(Long adharNumber) throws MemberException {
		// TODO Auto-generated method stub
		Member member = memberRepo.findMemberByAdharNumber(adharNumber);
		
		if(member == null) throw new MemberException("Member Not Found");
		
		return member;
	}

	@Override
	public Member addMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member updateMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		return null;
	}

}
