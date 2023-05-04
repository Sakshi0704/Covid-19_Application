package com.covid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.exception.IdCardException;
import com.covid.model.IdCard;
import com.covid.repository.IdCardRepository;

@Service
public class IdCardServiceImpl implements IdCardService{
	
	@Autowired
	private IdCardRepository idCardRepo;

	@Override
	public IdCard addIdCard(IdCard card) throws IdCardException {
		// TODO Auto-generated method stub
		if(card == null) throw new IdCardException("Provide necessory information");
		
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

	

	

}
