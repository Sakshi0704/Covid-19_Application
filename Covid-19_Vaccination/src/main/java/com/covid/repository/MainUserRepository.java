package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.MainUser;

@Repository
public interface MainUserRepository extends JpaRepository<MainUser, Integer>{
    public MainUser findUserByuserMobile(String userMobile);
   
}