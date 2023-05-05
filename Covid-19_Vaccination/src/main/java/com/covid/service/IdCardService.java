package com.covid.service;

import java.util.List;

import com.covid.exception.AdharCardException;
import com.covid.exception.IdCardException;
import com.covid.model.IdCard;

public interface IdCardService {
	public IdCard addIdCard(IdCard card) throws IdCardException, AdharCardException;
	
	public IdCard getAdharCardByNumber(Long adharNumber) throws IdCardException;
	
	public List<IdCard> getAllIdCard() throws IdCardException;
}
