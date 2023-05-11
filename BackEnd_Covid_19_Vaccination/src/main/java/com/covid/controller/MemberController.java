 package com.covid.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.Appointment;
import com.covid.model.IdCard;
import com.covid.model.IdProof;
import com.covid.model.Member;
import com.covid.repository.AppointmentRepo;
import com.covid.repository.IdCardRepository;
import com.covid.repository.IdProofRepository;
import com.covid.repository.MemberRepository;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.covid.exception.AppointmentException;
// import com.covid.exception.IdCardException;
// import com.covid.exception.MemberException;
// import com.covid.model.Appointment;
// import com.covid.model.IdCard;
// import com.covid.model.IdProof;
// import com.covid.model.Member;
// import com.covid.service.AppointmentService;
// import com.covid.service.MemberService;



// // @RestController
// // public class MemController {

// //     @Autowired
// //     private AppointmentService appoint;

// //     @Autowired
// //     private MemberService memberService;
    

// //     @GetMapping("/cov")
// //     public List<Member> getAllmem() throws MemberException{
// //        List<Member> list =  memberService.getAllMembers();
// //        return list;
// //     }



// //     @PostMapping("/cov")
// //     public Member addMember(@RequestBody Member member) throws AppointmentException, MemberException, IdCardException {
// //         List<Appointment> appointList = appoint.getAllAppointment();
        
// //         for (Appointment appointment : appointList) {
// //           // member = new Member();
// //             if (appointment.isBookingstatus()) {
               
// //                 member.setDose1Status(true);
// //                 member.setDose2Status(false);
// //                 member.setDose1Date(appointment.getDateofbooking());
// //                 member.setDose2Date(null);
// //                 IdCard idCard = new IdCard();
// //                 idCard.setIdProof(new IdProof());
// //                 idCard.getIdProof().setIdName("some_name");
// //                 member.setIdCard(idCard);
// //               //  memb.setVaccine(appointment.getVaccine());
                
// //             }

            
// //         }
       
// //         return memberService.addMember(member);
     
// //     }
    
// // }

// @RestController
// public class MemController {

//     @Autowired
//     private AppointmentService appoint;

//     @Autowired
//     private MemberService memberService;

//     @GetMapping("/members")
//     public List<Member> getAllMembers() throws MemberException{
//         List<Member> list =  memberService.getAllMembers();
//         return list;
//     }

//     @PostMapping("/members")
//     public Member addMember(@RequestBody Member member) throws AppointmentException, MemberException, IdCardException {
//         List<Appointment> appointList = appoint.getAllAppointment();

//         for (Appointment appointment : appointList) {
//             if (appointment.isBookingstatus()) {
//                 member.setDose1Status(true);
//                 member.setDose2Status(false);
//                 member.setDose1Date(appointment.getDateofbooking());

//                 IdCard idCard = new IdCard();
//                 idCard.setIdProof(new IdProof());
//                 idCard.getIdProof().setIdName("some_name");
//                 member.setIdCard(idCard);
//             }
//         }

//         return memberService.addMember(member);
//     }
// }

    
@RestController
public class MemberController{

    @Autowired
    private MemberRepository MemberRepository;

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private IdCardRepository idCardRepository;

    @Autowired
    private IdProofRepository idProofRepository;


    @GetMapping("/member")
    public List<Member> getAllMembers(){
        List<Member> list = MemberRepository.findAll();
        return list;
    }


    @PostMapping("/member/{bookingid}/{idproofnumber}")
    public Member addMember(@RequestBody Member member, @PathVariable Long bookingid,
    @PathVariable String idproofnumber ){
       Appointment appointment = appointmentRepo.findById(bookingid).get();
       if(appointment.isBookingstatus()&&!member.isDose1Status()){
            member.setDose1Date(appointment.getDateofbooking());
       

       if(LocalDate.now().isEqual(member.getDose1Date())){
        member.setDose1Status(true);
       }
    }

    else if(appointment.isBookingstatus()&&member.isDose1Status()&&!member.isDose2Status()){
        member.setDose2Date(appointment.getDateofbooking());
        if(LocalDate.now().isEqual(member.getDose2Date())){
            member.setDose2Status(true);
        
    }
       
       
    }

    if(appointment.isBookingstatus()){
        IdProof idproof = idProofRepository.findByIdNumber(idproofnumber);
   System.out.println("============================================"+idproof);
   member.setAppointment(appointment);
    member.setIdProof(idproof);


    }

    return MemberRepository.save(member);
}
}