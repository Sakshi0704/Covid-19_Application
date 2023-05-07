package com.covid.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.covid.exception.AppointmentException;
import com.covid.model.Appointment;
import com.covid.service.AppointmentService;

@Controller
public class AppointmentController {

@Autowired
private AppointmentService appointmentService;





    @GetMapping("/appoint")
    public String getAppointment(Model model){
        model.addAttribute("appointment", new Appointment());
        return "appointment";
    }

    @PostMapping("/appointment")
    public String createAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) throws AppointmentException{
        Appointment appoint = appointmentService.addAppointment(appointment);
       if(appoint!=null){
        // String confirmationMessage = "Your appointment has been booked successfully!";
        // model.addAttribute("bookingConfirmation", confirmationMessage);
           

       }
  
        return "redirect:/schedule";
    }

    @GetMapping("/schedule")
    public String listOfVaccinationCentre(Model model) throws AppointmentException {
        List<Appointment> appointments = appointmentService.getAllAppointment();
        model.addAttribute("appointment", appointments);
        return "listOfAppointments";
    }



    // @GetMapping("/schedule")
    // public String listOfVaccinationCentre(Model model, @RequestParam("mobile") String mobile) throws AppointmentException{
    
    //     List<Appointment> appointments = appointmentService.getAllAppointment();
    //     List<Appointment> appointmentsByMobile = new ArrayList<>();
    
    //     for (Appointment appointment : appointments) {
    //         if (appointment.getMobileno().equals(mobile)) {
    //             appointmentsByMobile.add(appointment);
    //         }
    //     }
    
    //     model.addAttribute("appointmentsByMobile", appointmentsByMobile);
    //     return "listOfAppointments";
    // }
    
    
}