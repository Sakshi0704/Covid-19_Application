package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.exception.IdCardException;
import com.covid.model.IdCard;
import com.covid.service.IdCardService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/covid")
public class IdCardController {

	@Autowired
	private IdCardService idCardService;
	
	
	@GetMapping("/idcard/{adharNo}")
	public ResponseEntity<IdCard> getIdCardByAdharCardNoHandler(@Valid @PathVariable String adharNo) throws IdCardException{
		
		IdCard idCard = idCardService.getIdCardByAdharCardNo(adharNo);
		
		return new ResponseEntity<>(idCard,HttpStatus.FOUND);
	}
	
	
	
	@PostMapping("/idcard")
	public ResponseEntity<IdCard> addIdCard(@Valid @RequestBody IdCard idCard) throws IdCardException{
	
		IdCard saveIdCard = idCardService.addIdCard(idCard);
		
		
		return new ResponseEntity<>(saveIdCard,HttpStatus.ACCEPTED);
	}
	
}
