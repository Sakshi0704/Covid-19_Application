package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.IdCard;
import com.covid.model.IdProof;
import com.covid.repository.IdCardRepository;
import com.covid.repository.IdProofRepository;

@RestController
public class IdProofController {


    @Autowired
    private IdProofRepository idProofRepository;

    @Autowired
    private IdCardRepository idCardRepository;

    @GetMapping("/idproof")
    public List<IdProof> getAllIdProof(){

        List<IdProof> list = idProofRepository.findAll();
        return list;
        
    }


    @PostMapping("/idproof")
    public IdProof addIdProof(@RequestBody IdProof idProof){
  
       return idProofRepository.save(idProof);
    }

    
}