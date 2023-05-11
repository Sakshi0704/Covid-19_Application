package com.covid.rcontroller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.IdCard;
import com.covid.model.IdProof;
import com.covid.service.IdCardService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/covid")
public class IDCardRestController {

	@Autowired
	private IdCardService idCardService;
	
	//Get(for getting) , post(for adding) , put(for updating)  , delete , patch(for pertail update)
	
	/*
	 * 
	 */
//	 @PostMapping("/idproof")
//	 public IdProof saveIdProof(@RequestBody IdProof idProof) {
//	
//		 
//		return null; 
//	 }
	
	
	

	
	
	/*
	 * For User
	 * 
	 * 
	 */
	@PostMapping("/idcard")
	public ResponseEntity<IdCard> saveIdCardHandler(@Valid @RequestBody IdCard idCard) {
		
		IdCard CreatedidCard = idCardService.saveIdCard(idCard);
		
		return new ResponseEntity<IdCard>(CreatedidCard,HttpStatus.CREATED);
	}
	
	
	
	
	
	
	/*
	 * For Admin
	 * 
	 * 
	 */
	@GetMapping("/allidcards")
	public ResponseEntity<List<IdCard>> getAllIdCardsHandler(){
		List<IdCard> IdCards = idCardService.getAllIdCards();
		
		return new ResponseEntity<>(IdCards,HttpStatus.OK);
	}
	
	
	
	
	/*
	 * For User or Admin
	 * 
	 * 
	 */
	@GetMapping("/idcard/{id}")
	public ResponseEntity<IdCard> getIdCardByIdHandler(@PathVariable Integer id){
	
		Optional<IdCard> idCard = idCardService.getIdCardById(id);
		
		return new ResponseEntity<>(idCard.get(),HttpStatus.FOUND);
	}
	
	
	/*
	 * for Admin
	 * 
	 * 
	 */
	@GetMapping("/idCards/{moblie}")
	public ResponseEntity<List<IdCard>> getAllCardsByMobileHandler(@PathVariable String mobile){
		
		List<IdCard> allIdCards = idCardService.findByMobile(mobile);
		
		return new ResponseEntity<List<IdCard>>(allIdCards,HttpStatus.FOUND);
		
	}
	
	
	
	/*
	 * 
	 */
	@PatchMapping("/idcard/{id}")
	public void updateIdCardHandler(@PathVariable Integer id, @Valid @RequestBody IdCard idCard) {
		
		idCardService.updateIdCard(id, idCard);
		
	}
	
	
	
	 /*
	  * 
	  */
	@DeleteMapping("/idcard/{id}")
	 public void deleteIdCardHandler(@PathVariable Integer id) {
		
		 idCardService.deleteIdCard(id);
		 
	 }
	
}
