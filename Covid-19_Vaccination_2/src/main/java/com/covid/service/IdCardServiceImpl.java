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
	public IdCard getIdCardByAdharCardNo(String adharNo) throws IdCardException {
		
		IdCard idCard =  idCardRepo.findByAadharNo(adharNo);                                                                                                                                                                                                                        
		
		
		if(idCard==null) {
			throw new IdCardException("IdCard is not avaiable");
		}
		
		return idCard;
	}

	@Override
	public IdCard addIdCard(IdCard idCard) throws IdCardException {
		
		IdCard existingIdCard =  idCardRepo.findByAadharNo(idCard.getAadharNo());  
		
		if(existingIdCard!=null) {
			throw new IdCardException("This IdCard is available with given aadharNo "+ idCard.getAadharNo());
		}
		
		IdCard saveIdCard = idCardRepo.save(idCard);
		
		
		return saveIdCard;
	}

}
