package com.covid.rcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.exception.AppointmentException;
import com.covid.model.MainUser;
import com.covid.service.MainUserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/covid")
public class MainUserRestController {

	@Autowired
	private MainUserService mainUserService;
	
	//Get(for getting) , post(for adding) , put(for updating)  , delete , patch(for pertail update)
	
	
	
	/**
	 * For User
	 * This handler is adding new User.
	 *
	 * @param   A User Object
	 * @return  A ResponseEntity object containing a user object which is register into database and HTTP status code OK
	 * @exception MainUserException if providing appointment is invalid..
	 */
	@PostMapping("/user")
	public ResponseEntity<MainUser> addUserHandler(@Valid @RequestBody MainUser mainuser) {
		
			MainUser user = mainUserService.addUser(mainuser.getUserMobile(), mainuser);
		
			return new ResponseEntity<MainUser>(user, HttpStatus.ACCEPTED);
	}
	
	
	
	
	/**
	 * for user or Admin
	 * 
	 * @param Through userMobile we get user details...
	 * @return  user object and Http status
	 * @exception  MainUserException if providing appointment is invalid..
	 */
	@GetMapping("/user/{userMobile}")
	public ResponseEntity<MainUser> getUserByMobileHandler(String userMobile) {
		
		MainUser user = mainUserService.findUserByuserMobile(userMobile);
		
		
		return new ResponseEntity<MainUser>(user,HttpStatus.FOUND);
		
	}
	
}
