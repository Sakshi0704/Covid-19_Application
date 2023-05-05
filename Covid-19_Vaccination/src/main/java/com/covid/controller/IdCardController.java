package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.exception.AdharCardException;
import com.covid.exception.IdCardException;
import com.covid.model.IdCard;
import com.covid.service.IdCardService;

import jakarta.validation.Valid;

@RestController
public class IdCardController {

	@Autowired
	private IdCardService idCardService;

	@PostMapping("/users")
	public ResponseEntity<IdCard> addIdCard(@Valid @RequestBody IdCard card) throws IdCardException, AdharCardException {

		IdCard registeredCard = idCardService.addIdCard(card);

		return new ResponseEntity<>(registeredCard, HttpStatus.ACCEPTED);
	}
	
	

//	@GetMapping("/users")
//	public ResponseEntity<List<IdCard>> getAllUsers() throws IdCardException {
//
//		List<IdCard> listOfUsers = idCardService.getAllUsers();
//
//		return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
//	}
}
