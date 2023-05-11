package com.covid.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.IdCard;
import com.covid.model.MainUser;
import com.covid.repository.MainUserRepository;


import jakarta.validation.Valid;

// @RestController

// public class MainUserController {

//     @Autowired
//     private MainUserService mainUserService;

//     @GetMapping("/users")
//     public List<MainUser> getAllMainUsers() {
//         return mainUserService.getAllMainUsers();
//     }

//     @GetMapping("/users/{id}")
//     public MainUser getMainUserById(@PathVariable Integer id) {
//         return mainUserService.getMainUserById(id);
//     }

//     @PostMapping("/users")
//     public MainUser createMainUser(@Valid @RequestBody MainUser mainUser) {
//         return mainUserService.createMainUser(mainUser);
//     }

//     @PutMapping("/users/{id}")
//     public MainUser updateMainUser(@PathVariable Integer id, @Valid @RequestBody MainUser mainUserDetails) {
//         return mainUserService.updateMainUser(id, mainUserDetails);
//     }

//     @DeleteMapping("/users/{id}")
//     public ResponseEntity<?> deleteMainUser(@PathVariable Integer id) {
//         return mainUserService.deleteMainUser(id);
//     }

//     @GetMapping("/users/{mainUserId}/idcards")
//     public Set<IdCard> getAllIdCardsByMain(@PathVariable Integer mainUserId) {
//         return mainUserService.getAllIdCardsByMainUserId(mainUserId);
//     }

//     @PostMapping("/users/{mainUserId}/idcards")
//     public IdCard createIdCard(@PathVariable Integer mainUserId, @Valid @RequestBody IdCard idCard) {
//         return mainUserService.createIdCard(mainUserId, idCard);
//     }

//     // @PutMapping("/idcards/{id}")
//     // public IdCard updateIdCard(@PathVariable Integer id, @Valid @RequestBody IdCard idCardDetails) {
//     //     return mainUserService.updateIdCard(id, idCardDetails);
//     // }

//     // @DeleteMapping("/idcards/{id}")
//     // public ResponseEntity<?> deleteIdCard(@PathVariable Integer id) {
//     //     return mainUserService.deleteIdCard(id);
//     // }
// }

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainUserController{

    @Autowired
    private MainUserRepository mainUserRepository;

@GetMapping("/mainusers")
public List<MainUser> getAllMainUsers(){
    List<MainUser> list = mainUserRepository.findAll();
    return list;
}

@PostMapping("/mainusers")

public MainUser addMainUser(@RequestBody MainUser mainUser){
  //  MainUser mainuser = mainUserRepository.findUserByuserMobile(mobileNumber);
   
    return mainUserRepository.save(mainUser);
}


}