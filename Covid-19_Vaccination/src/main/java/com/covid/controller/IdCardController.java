package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.exception.IdCardException;
import com.covid.model.IdCard;
import com.covid.service.IdCardService;

import jakarta.validation.Valid;

@RestController
public class IdCardController {

	@Autowired
	private IdCardService idCardService;

	@PostMapping("/users")
	public ResponseEntity<IdCard> addIdCard(@Valid @RequestBody IdCard card) throws IdCardException {

		IdCard registeredUser = idCardService.registerNewUser(card);

		return new ResponseEntity<>(registeredUser, HttpStatus.ACCEPTED);
	}

	@GetMapping("/users")
	public ResponseEntity<List<IdCard>> getAllUsers() throws IdCardException {

		List<IdCard> listOfUsers = idCardService.getAllUsers();

		return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
	}
}
