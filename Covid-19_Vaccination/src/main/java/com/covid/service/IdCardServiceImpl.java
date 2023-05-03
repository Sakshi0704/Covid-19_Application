package com.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.exception.IdCardException;
import com.covid.model.IdCard;
import com.covid.repository.IdCardRepo;

@Service
public class IdCardServiceImpl implements IdCardService{
	
	@Autowired
	private IdCardRepo idCardRepo;

	@Override
	public IdCard registerNewUser(IdCard card) throws IdCardException {
		// TODO Auto-generated method stub
		if(card == null) throw new IdCardException("Provide necessory information");
		
		IdCard registeredUser = idCardRepo.save(card);
		
		return registeredUser;
	}

	@Override
	public List<IdCard> getAllUsers() throws IdCardException {
		// TODO Auto-generated method stub
		
		List<IdCard> listOfUsers = idCardRepo.findAll();
		
		if(listOfUsers.isEmpty()) throw new IdCardException("No User Found");
		
		return listOfUsers;
	}

	

}
