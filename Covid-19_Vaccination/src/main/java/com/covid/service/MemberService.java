package com.covid.service;

import java.util.List;

import com.covid.exception.IdCardException;
import com.covid.exception.MemberException;
import com.covid.model.Member;

public interface MemberService {
	
	public List<Member> getAllMembers() throws MemberException;
	
	public Member getMemberById(Integer memberId) throws MemberException;
	
	public Member getMemberByAdharNo(Long adharNumber) throws MemberException;
	
	public Member addMember(Member member) throws MemberException, IdCardException;
	
	public Member updateMember(Member member) throws MemberException, IdCardException;
	
	public Boolean deleteMember(Member member) throws MemberException;
	
}
