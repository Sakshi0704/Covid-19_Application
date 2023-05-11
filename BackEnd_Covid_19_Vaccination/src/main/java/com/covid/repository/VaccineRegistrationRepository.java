package com.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.Member;
import com.covid.model.VaccineRegistration;

import jakarta.websocket.server.PathParam;


@Repository
public interface VaccineRegistrationRepository extends JpaRepository<VaccineRegistration, Integer>{
	
	public VaccineRegistration findByMobileNo(String MobileNo);

}
