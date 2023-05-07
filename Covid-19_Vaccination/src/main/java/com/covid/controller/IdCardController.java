package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.covid.model.IdCard;
import com.covid.model.IdProof;
import com.covid.model.MainUser;
import com.covid.repository.IdCardRepository;
import com.covid.service.IdCardService;
import com.covid.service.MainUserService;

@Controller
public class IdCardController {

    @Autowired
    private IdCardService idCardService;

    @Autowired
    private MainUserService mainUserService;

    @GetMapping("/member/new")
    public String createNewMember(Model model) {
        model.addAttribute("idcard", new IdCard());
        return "memberRagistration";
    }

    @PostMapping("/hi")
    public String addNewMember(@ModelAttribute("idcard") IdCard idcard) {
        // idcard.setMobile(null);
        
       // MainUser user = mainUserService.findUserByuserMobile(idcard.getMobile());
   System.out.println("seeeeeeeee==========================================");
   
   MainUser user = mainUserService.findUserByuserMobile(idcard.getMainuser().getUserMobile());
        if (user != null) {
            IdCard existing = idCardService.saveIdCard(idcard);
        }
        else{
            return "redirect:/dashboard";
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/idproof/new")
    public String addNewId(Model model) {
        model.addAttribute("idproof", new IdProof());
        return "idProofRagistration";
    }

    @PostMapping("idproof")

    public String createNewIdProof(@ModelAttribute("idproof") IdProof idproof) {
        idCardService.saveIdProof(idproof);

        return "redirect:/";
    }

    // @GetMapping("/conmob")
    // public String confirmMobile(@RequestParam("userMobile") String userMobile,
    //         @ModelAttribute("user") MainUser mainuser, Model model) {

    //     MainUser mainUser = mainUserService.findUserByuserMobile(userMobile);

    //     if (mainUser == null) {
    //         return "redirect:/";
    //     } else {
    //         return "verifyMobileNumber";
    //     }

    // }

    // @GetMapping("/mobile")
    // public String getMobile(Model model){

    // model.addAttribute("user", new MainUser());
    // return "verifyMobileNumber";
    // }

    @GetMapping("/dashboard")
    public String listOfVaccineMember(Model model) {

        // model.addAttribute("usermobile", userMobile);
        model.addAttribute("getall", idCardService.getAllIdCards());
        return "dashboard";
    }

    // @GetMapping("/dashboard")
    // public String listOfVaccineMember(@RequestParam String userMobile, Model
    // model){

    // List<IdCard> idCards = idCardService.findByMobile(userMobile);
    // model.addAttribute("idCards", idCards);
    // model.addAttribute("userMobile", userMobile);
    // return "dashboard";
    // }

}

// @GetMapping("/dashbord")

// public String dashboard(){

// }
