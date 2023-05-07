package com.covid.service;

import com.covid.model.MainUser;

public interface MainUserService {

    public MainUser addUser(String mobileNumber, MainUser mainuser);

    public MainUser findUserByuserMobile(String userMobile);
    
}