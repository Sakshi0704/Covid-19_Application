package com.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.exception.AdharCardException;
import com.covid.exception.IdCardException;
import com.covid.model.IdCard;
import com.covid.model.Member;
import com.covid.repository.IdCardRepository;
import com.covid.repository.MemberRepository;

@Service
public class IdCardServiceImpl implements IdCardService{
	
	@Autowired
	private IdCardRepository idCardRepo;
	
	@Autowired
	private MemberRepository memberRepo;

	@Override
	public IdCard addIdCard(IdCard card) throws IdCardException, AdharCardException {
		// TODO Auto-generated method stub
		if(card == null) throw new IdCardException("Provide necessory information");
		
		/*
		 * Cheking for member having the same adhar number 
		 * if found then stop the process here and throw the exceptio;
		 */
		if(memberRepo.findMemberByAdharNumber(card.getAdharCard().getAdharNumber()) != null) {
			throw new AdharCardException("Member with same Adhar Number already exists");
		}
		
		/*
		 * putting an member object into IdCard with default values
		 */
		Member member = new Member();
		member.setDose1Status(false);
		member.setDose2Status(false);
		member.setDose1Date(null);
		member.setDose2Date(null);
		
		card.setMember(member);
		member.setIdCard(card);
		
		IdCard registeredUser = idCardRepo.save(card);
		
		return registeredUser;
	}

	@Override
	public IdCard getAdharCardByNumber(Long adharNumber) throws IdCardException {
		// TODO Auto-generated method stub
		IdCard card = idCardRepo.getAdharByNumber(adharNumber);
		
		if(card == null) throw new IdCardException("Not Present in the system");
		
		return card;
	}

	@Override
	public List<IdCard> getAllIdCard() throws IdCardException {
		// TODO Auto-generated method stub
		
		List<IdCard> listOfIdCards = idCardRepo.findAll();
		
		if(listOfIdCards.isEmpty()) throw new IdCardException("No IdCards Available");
		
		return listOfIdCards;
	}

	

	

}
