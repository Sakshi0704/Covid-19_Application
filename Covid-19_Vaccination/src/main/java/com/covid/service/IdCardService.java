package com.covid.service;

import java.util.List;
import java.util.Optional;

import com.covid.exception.AdharCardException;
import com.covid.exception.IdCardException;
import com.covid.model.IdCard;
import com.covid.model.IdProof;

public interface IdCardService {
	public IdCard saveIdCard(IdCard idCard);

    public IdProof saveIdProof(IdProof idproof);

    public List<IdCard> getAllIdCards();

    public Optional<IdCard> getIdCardById(Integer id);
   // IdCard findByUserMobile(String mobile);
    //public Optional<IdCard> getIdCardByIdProof(IdProof idProof);
    public List<IdCard> findByMobile(String mobile);
    public void deleteIdCard(Integer id);

    public void updateIdCard(Integer id, IdCard idCard);
}
