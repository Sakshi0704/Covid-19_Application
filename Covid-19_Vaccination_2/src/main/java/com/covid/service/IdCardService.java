package com.covid.service;

import com.covid.exception.IdCardException;
import com.covid.model.IdCard;

public interface IdCardService {

	public IdCard getIdCardByAdharCardNo(String adharNo) throws IdCardException;
	
	public IdCard addIdCard(IdCard idCard) throws IdCardException; 
	
}
