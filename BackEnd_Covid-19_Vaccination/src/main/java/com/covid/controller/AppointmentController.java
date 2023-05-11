 package com.covid.controller;

import java.time.LocalDate;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.covid.exception.AppointmentException;
// import com.covid.model.Appointment;
// import com.covid.service.AppointmentService;

// @Controller
// public class AppointmentController {

// @Autowired
// private AppointmentService appointmentService;





//     @GetMapping("/appoint")
//     public String getAppointment(Model model){
//         model.addAttribute("appointment", new Appointment());
//         return "appointment";
//     }

//     @PostMapping("/appointment")
//     public String createAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) throws AppointmentException{
//         Appointment appoint = appointmentService.addAppointment(appointment);
//        if(appoint!=null){
//         // String confirmationMessage = "Your appointment has been booked successfully!";
//         // model.addAttribute("bookingConfirmation", confirmationMessage);
           

//        }
  
//         return "redirect:/schedule";
//     }

//     @GetMapping("/schedule")
//     public String listOfVaccinationCentre(Model model) throws AppointmentException {
//         List<Appointment> appointments = appointmentService.getAllAppointment();
//         model.addAttribute("appointment", appointments);
//         return "listOfAppointments";
//     }




//     @GetMapping("/schedule/{bookingid}")
//     public String deleteVaccinationCentre(@PathVariable Long bookingid) throws AppointmentException{
//         appointmentService.deleteAppointment(bookingid);
//         return "redirect:/schedule";
//     }


    
//     @GetMapping("/schedule/reschedule/{bookingid}")
//     public String rescheduleVaccinationCentre(@PathVariable Long bookingid) throws AppointmentException{
//         appointmentService.deleteAppointment(bookingid);
//         return "redirect:/appoint";
//     }



//     // @GetMapping("/schedule")
//     // public String listOfVaccinationCentre(Model model, @RequestParam("mobile") String mobile) throws AppointmentException{
    
//     //     List<Appointment> appointments = appointmentService.getAllAppointment();
//     //     List<Appointment> appointmentsByMobile = new ArrayList<>();
    
//     //     for (Appointment appointment : appointments) {
//     //         if (appointment.getMobileno().equals(mobile)) {
//     //             appointmentsByMobile.add(appointment);
//     //         }
//     //     }
    
//     //     model.addAttribute("appointmentsByMobile", appointmentsByMobile);
//     //     return "listOfAppointments";
//     // }
    
    
// }

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.Appointment;
import com.covid.model.IdCard;
import com.covid.model.Slot;
import com.covid.model.UserAppointmentDTO;
import com.covid.model.VaccinationCentre;
import com.covid.model.VaccineInventory;
import com.covid.repository.AppointmentRepo;
import com.covid.repository.IdCardRepository;
import com.covid.repository.VaccinationCentreRepository;


@RestController
@RequestMapping("/covid")
public class AppointmentController{

	@Autowired 
	private IdCardRepository idCardRepository;
	
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private VaccinationCentreRepository vaccinationCentreRepository;

    @GetMapping("/appointment")
    public List<Appointment> getAllAppointment(){
        List<Appointment> list =  appointmentRepo.findAll();
        return list;
    }


    @PostMapping("/appointment/{vaccinationcentreid}")
    public Appointment addAppointment(@RequestBody Appointment appointment, @PathVariable Long vaccinationcentreid){
      // appointment.setSlot(slot);
      VaccinationCentre  vaccinationCentre = vaccinationCentreRepository.findById(vaccinationcentreid).get();
      appointment.setVaccinationCentre(vaccinationCentre);
      
      return appointmentRepo.save(appointment);
    }
    
    
    @PostMapping("/appointment")
    public Appointment registerAppointment(@RequestBody UserAppointmentDTO appointmentDTO) {

    	System.out.println("start this handler");
    	
    	Appointment appointment = new Appointment();
    	VaccineInventory vaccineInventory = new VaccineInventory();
    	
    	Integer id = appointmentDTO.getRefId();
    	Optional<IdCard> existingIdCard = idCardRepository.findById(id);
    	
    	if(existingIdCard.isPresent()) {
    		
    		System.out.println("idCard varified");
    		
    		Long centreId = appointmentDTO.getCentreId();
    		Optional<VaccinationCentre> existingCentre = vaccinationCentreRepository.findById(centreId);
    		
    		if(existingCentre.isPresent()) {
    			
    			System.out.println("centre varified");
    			
    			LocalDate date = appointmentDTO.getDateOfAppointment();
    			
    			List<VaccineInventory> vaccineInventorys = existingCentre.get().getVaccineInventoryList();
    			
    			
    			for(VaccineInventory elem : vaccineInventorys) {
    				
    				if(elem.getDate().equals(date)) {
    					vaccineInventory = elem;
    				}
    			}
    			
    			System.out.println("vaccneInventory"+vaccineInventory);
    			
    			if(vaccineInventory != null) {
    				
    				System.out.println("vaccneInventory"+vaccineInventory);
    				
    				Appointment existingAppointment = appointmentRepo.findByIdcard(existingIdCard.get());
    	
    				
    				
    				if(existingAppointment == null){
    					appointment.setBookingstatus(false);
    						appointment.setDateofbooking(LocalDate.now());
    						appointment.setIdcardNo(existingIdCard.get());
    						appointment.setSlot(appointmentDTO.getSlot());
    						appointment.setVaccinationCentre(existingCentre.get());
    				
    						appointment.setAppointmentDate(date);
    					
    						appointmentRepo.save(appointment);
    		    			   System.out.println("appointment add seccusssfully ");
    						
    				}else {
    					System.out.println(existingAppointment.getBookingid());
    				}
    				
    			   
    				
    				
    			}else {
    				
    			}
    			
    			if(date != null) {
    				
    			}
    			
    		}else {
    			
    			
    			
    		}
    		
    		
    	}else {
    		
    	}
    	
    	return appointment;
    }
}