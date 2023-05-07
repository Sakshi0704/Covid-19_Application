package com.covid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.model.MainUser;
import com.covid.repository.MainUserRepository;

@Service
public class MainUserServiceImpl implements MainUserService{

    @Autowired
    private MainUserRepository  mainUserRepository;

    @Override
    public MainUser addUser(String mobileNumber, MainUser mainuser) {
        MainUser existingUser = mainUserRepository.findUserByuserMobile(mobileNumber);
        if (existingUser == null) {
       
            MainUser user= mainUserRepository.save(mainuser);
            System.out.println(user+"============================ Yes");
            return user;
    }
    System.out.println(existingUser+"============================== Not ");
    return null;
}

    @Override
    public MainUser findUserByuserMobile(String userMobile) {
        System.out.println("======================service");
        return mainUserRepository.findUserByuserMobile(userMobile);
    }

   

    // @Override
    // public MainUser findByMobileNumber(String mobileNumber) throws Exception {
        
    //     MainUser existingUser = mainUserRepository.findByUserByMobile(mobileNumber);
    //     if (existingUser == null) {
    //         return existingUser;
    //     }

    //     else{
    //         mainUserRepository.save(null)
    //     }
       
   
    // }
    
}