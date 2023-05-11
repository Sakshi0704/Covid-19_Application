// package com.covid.restapicontroller;


// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.covid.model.MainUser;
// import com.covid.service.MainUserService;

// import org.springframework.web.bind.annotation.RequestBody;
// import jakarta.validation.Valid;

// @RestController
// public class UserMainController {

//     @Autowired
//     private MainUserService mainUserService;

//     @GetMapping("/covid")
//     public List<MainUser> getMainUser(){
//         List<MainUser> mainUser =  mainUserService.getAllUsers();
//         return mainUser;
//     }

//     @PostMapping("/covid/add")
//     public MainUser addMainUser(@Valid @RequestBody MainUser mainu){
//         // MainUser ma = new MainUser();
//         // ma.setUserMobile("3214567890");
//         // ma.setOtp(1234);
//         return mainUserService.addMainUser(mainu);

        
//     }
 
// }