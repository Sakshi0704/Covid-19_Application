// package com.covid.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.covid.model.MainUser;
// import com.covid.service.MainUserService;

// @Controller
// public class DemoController {


//     @Autowired
//     private MainUserService  mainuserservice;

    
// @GetMapping("/")
// public String goHome(){
//     return "index";
// }


    
// @GetMapping("/register/new")
// public String createVaccineForm(Model model) throws Exception {
 
//      model.addAttribute("user", new MainUser());

//     return "fillRagistrationForm";
// }

// @PostMapping("/add")
// public String createUser(@ModelAttribute("user") MainUser mainuser, Model model)  {
  
//     MainUser existingUser= mainuserservice.addUser(mainuser.getUserMobile(), mainuser);
//     if(existingUser==null){
//         System.out.println(existingUser+"====================================== yes");
//         return "redirect:/dashboard";
//     }
//     else{
//         System.out.println(existingUser+"========================================== not");
//         // return "ragistraionForVaccination";
//         return "redirect:/dashboard";
//     }
    
    
// }
// }