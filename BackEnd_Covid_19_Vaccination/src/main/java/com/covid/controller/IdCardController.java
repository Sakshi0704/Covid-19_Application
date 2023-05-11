

package com.covid.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.IdCard;
import com.covid.model.IdProof;
import com.covid.model.MainUser;
import com.covid.repository.IdCardRepository;
import com.covid.repository.IdProofRepository;
import com.covid.repository.MainUserRepository;


import jakarta.validation.Valid;

 @RestController

 public class IdCardController {

    @Autowired
    private IdCardRepository idCardRepository;

    @Autowired
    private IdProofRepository idProofRepository;

    @Autowired
    private MainUserRepository mainUserRepository;

    @GetMapping("/idcard")
public List<IdCard> getIdCard(){
    List<IdCard> list = idCardRepository.findAll();
    return list;
}


@PostMapping("/idcard/{mobile}/{idproofNumber}")
public IdCard addIdCard(@RequestBody IdCard idcard, @PathVariable String mobile, @PathVariable String idproofNumber){
  IdProof idproof = idProofRepository.findByIdNumber(idproofNumber);
  
    MainUser mainuser = mainUserRepository.findUserByuserMobile(mobile);
   idcard.setMainuser(mainuser);
   idcard.setIdProof(idproof);
   idCardRepository.save(idcard);

   return idcard;

}



}