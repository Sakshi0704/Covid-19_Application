package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.Appointment;
import com.covid.model.IdCard;






@Repository
public interface AppointmentRepo extends JpaRepository<Appointment ,Long> {

	public Appointment findByIdcard(IdCard idcard);

	
}