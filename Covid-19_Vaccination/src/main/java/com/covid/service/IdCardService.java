package com.covid.service;

import java.util.List;

import com.covid.exception.IdCardException;
import com.covid.model.IdCard;

public interface IdCardService {
	public IdCard registerNewUser(IdCard card) throws IdCardException;
	
	public List<IdCard> getAllUsers() throws IdCardException;
}
