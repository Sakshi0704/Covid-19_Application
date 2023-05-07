package com.covid.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.service.VaccinationCentreService;

@RestController
@RequestMapping("/covid")
public class VaccinationCenterController {

	@Autowired
	private VaccinationCentreService vaccinationCentreService;
	
	
	
	//Get(for getting) , post(for adding) , put(for updating)  , delete , patch(for pertail update)
	
	
	
}
