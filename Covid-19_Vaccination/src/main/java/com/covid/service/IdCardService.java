package com.covid.service;

import java.util.List;

import com.covid.exception.IdCardException;
import com.covid.model.IdCard;

public interface IdCardService {
	public IdCard addIdCard(IdCard card) throws IdCardException;
	
	public IdCard getAdharCardByNumber(Long adharNumber) throws IdCardException;
}
