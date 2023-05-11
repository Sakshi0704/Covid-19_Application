package com.covid.rcontroller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.covid.exception.AppointmentException;
import com.covid.model.VaccinationCentre;
import com.covid.service.VaccinationCentreService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/covid")
public class VaccinationCentreRestController {

	@Autowired
	VaccinationCentreService vaccinationCentreService;
	
	//Get(for getting) , post(for adding) , put(for updating)  , delete , patch(for pertail update)
	
	/**
	 * For Admin....
	 * This handler is providing all vaccination centres to the system.
	 *
	 * @param  nothing..
	 * @return A ResponseEntity object containing List of centres and HTTP status code OK
	 * @exception VaccinationCentreException if no centre found..
	 */
	@GetMapping("/allcentres")
	public ResponseEntity<List<VaccinationCentre>> getAllVaccinationCentreHandler(){
		
		List<VaccinationCentre> allCentres =  vaccinationCentreService.getAllVaccinationCentre();
		
		return new ResponseEntity<>(allCentres,HttpStatus.FOUND);
		
	}
	
	

	/**
	 * For User Or Admin 
	 * This handler is providing specific centre to the system.
	 *
	 * @param  Taking centreId of appointment
	 * @return A ResponseEntity object containing a object of centre and HTTP status code OK
	 * @exception VaccinationCentreException if No appointment found of providing bookingId.. 
	 */
	@GetMapping("/vcentre/{centreId}")
	public ResponseEntity<VaccinationCentre> getVaccinationCentreById(@PathVariable Long centreId) {
		  
		VaccinationCentre vCentre = vaccinationCentreService.getVaccinationCentreById(centreId);
		
		return new ResponseEntity<>(vCentre, HttpStatus.FOUND);
		  
	}
	
	

	/**
	 * For Admin
	 * This handler is adding specific vaccination centre.
	 *
	 * @param   A Appointment Object
	 * @return  A ResponseEntity object containing a object which is register into database and HTTP status code OK
	 * @exception VaccinationCentreException if providing centre details invalid..
	 */
	@PostMapping("/vcentre")
	 public ResponseEntity<VaccinationCentre> saveVaccinationCentreHandler(@Valid @RequestBody VaccinationCentre vaccinationcentre) {
		 
		 VaccinationCentre vCentre = vaccinationCentreService.saveVaccinationCentre(vaccinationcentre);
		 
		 return new ResponseEntity<>(vCentre, HttpStatus.CREATED); 
	 }
	
	
	 /**
	  * For User
		 * This handler is updating specific centre.
		 *
		 * @param   A Appointment Object
		 * @return  A ResponseEntity containing a centre which is updated into database and HTTP status code OK
		 * @exception VaccinationCentreException if providing appointment is invalid..
	  */
	@PatchMapping(value = "/vcentre")
	public ResponseEntity<VaccinationCentre> updateVaccinationCentreHandler(@Valid @RequestBody VaccinationCentre vaccinationcentre) {
		
		VaccinationCentre vCentre = vaccinationCentreService.updateVaccinationCentre(vaccinationcentre);
		 
		 return new ResponseEntity<>(vCentre, HttpStatus.ACCEPTED); 
		
	}
	
	
	/*
	 * 
	 */
	@DeleteMapping("/vcentre/{centreId}")
	public ResponseEntity<String> deleteVaccinationCentreByIdHandler(@PathVariable Long centreId) {
		
		vaccinationCentreService.deleteVaccinationCentreById(centreId);
		
		return new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
		
	}
	
	 
	 
}
