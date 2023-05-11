package com.covid.rcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.covid.exception.AppointmentException;
import com.covid.model.Appointment;
import com.covid.service.AppointmentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/covid")
public class ApplicationRestController {

	@Autowired
	private AppointmentService appointmentService;
	
	//Get(for getting) , post(for adding) , put(for updating)  , delete , patch(for pertail update)
	
	
	
	
	/**
	 * For Admin....
	 * This handler is providing the all appointments to the system.
	 *
	 * @param  nothing..
	 * @return A ResponseEntity object containing List of appointments and HTTP status code OK
	 * @exception AppointmentException if no appointment found..
	 */
	@GetMapping("/appointments")
	 public ResponseEntity<List<Appointment>> getAllAppointmentHandler() throws AppointmentException{
		 
			List<Appointment> appointments = appointmentService.getAllAppointment();
			
			return new ResponseEntity<>(appointments, HttpStatus.FOUND);
	
	 }
	
	
	
	/**
	 * For User And Admin 
	 * This handler is providing specific appointment to the system.
	 *
	 * @param  Taking bookingId of appointment
	 * @return A ResponseEntity object containing a object of appointments and HTTP status code OK
	 * @exception AppointmentException if No appointment found of providing bookingId.. 
	 */
	@GetMapping("/appointment/{bookingId}")
	 public ResponseEntity<Appointment> getAppointmentHandler(@PathVariable("bookingId") long bookingid) throws AppointmentException{
		 
		Appointment appointments = appointmentService.getAppointment(bookingid);
		
		return new ResponseEntity<>(appointments,HttpStatus.FOUND);
		
	 }
	
	
	/**
	 * For User
	 * This handler is adding specific appointment.
	 *
	 * @param   A Appointment Object
	 * @return  A ResponseEntity object containing a object which is register into database and HTTP status code OK
	 * @exception AppointmentException if providing appointment is invalid..
	 */
	 @PostMapping("/appointment")
	 public ResponseEntity<Appointment> addAppointmentHandler(@Valid @RequestBody Appointment appointment)throws AppointmentException{
		 
		 Appointment createdAppointment = appointmentService.addAppointment(appointment);
		 
		 return new ResponseEntity<>(createdAppointment,HttpStatus.CREATED);
		 
	 }
	
	
	 /**
	  * For User
		 * This handler is updating specific appointment.
		 *
		 * @param   A Appointment Object
		 * @return  A ResponseEntity object containing a object which is update into database and HTTP status code OK
		 * @exception AppointmentException if providing appointment is invalid..
	  */
	 @PatchMapping("/appointment")
	 public ResponseEntity<Appointment> updateAppointmentHandler(@Valid @RequestBody Appointment appointment)throws AppointmentException{
		 
		 Appointment updateAppointment = appointmentService.updateAppointment(appointment);
		
		 return new ResponseEntity<>(updateAppointment , HttpStatus.ACCEPTED);
		 
	 }
	 
	 
	 /**
	  * For Deleting Specific appointment.
	  * 
	  * @Param	A Appointment Object
	  * @return   A ResponseEntity of boolean type which given true or false as a result and HTTP status code OK
	  * @exception  AppointmentException if providing appointment is invalid...
	  */
	 @DeleteMapping("/appointment")
	 public ResponseEntity<Boolean> deleteAppointmentHandler(@Valid @RequestBody Appointment appointment)throws AppointmentException{
		 
		 boolean deleteAppointment = appointmentService.deleteAppointment(appointment);
		 
		 return new ResponseEntity<>(deleteAppointment,HttpStatus.ACCEPTED);
		 
	 }
	

}

