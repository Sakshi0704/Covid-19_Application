package com.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.IdCard;
import com.covid.model.MainUser;


public interface MainUserRepository extends JpaRepository<MainUser, Integer>{
    public MainUser findUserByuserMobile(String userMobile);

   // public IdCard findIdCardById(Integer Id);

   // public IdCard save(IdCard idCard);

   
   
}