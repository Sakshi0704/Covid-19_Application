 package com.covid.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// import com.covid.exception.AppointmentException;
// import com.covid.model.Appointment;
// import com.covid.model.VaccineRegistration;
// import com.covid.service.AppointmentService;
// import com.covid.service.VaccineRegistrationService;



// @Controller
// public class VaccineRagistrationController {
    

//     @Autowired
//     private VaccineRegistrationService vaccineRegistrationService;

//     @Autowired
//     private AppointmentService appointser;

//     @PostMapping("/vaccineregistration")
//     public VaccineRegistration addVaccineRegistration(@RequestBody VaccineRegistration vaccineR) throws AppointmentException {
       
//        List<Appointment> appointList = appointser.getAllAppointment();

//     //    for(List<Appointment> list:appointList){

//     //    }
        
//         return vaccineR;
//     }
    
    
// }


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.covid.model.Appointment;
import com.covid.model.Member;
import com.covid.model.VaccineRegistration;
import com.covid.repository.MainUserRepository;
import com.covid.repository.MemberRepository;
import com.covid.repository.VaccineRegistrationRepository;

public class VaccineRagistrationController{


    @Autowired
    private VaccineRegistrationRepository VaccineRagistrationRepository;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/vaccineregistration")
    public List<VaccineRegistration> getAllVaccineRegistration(){
        List<VaccineRegistration> list = VaccineRagistrationRepository.findAll();
        return list;
    }

    @PostMapping("/vaccineregistration/{memberid}")
    public VaccineRegistration addVaccineRegistration(@RequestBody VaccineRegistration vaccineRegistration, @PathVariable Integer memberid){
        Member member = memberRepository.findById(memberid).get();

        if(member.isDose1Status()||member.isDose2Status()){
           //logic is pending
        }
        return vaccineRegistration;
    }
}