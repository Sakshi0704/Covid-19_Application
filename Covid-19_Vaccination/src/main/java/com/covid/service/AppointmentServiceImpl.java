package com.covid.service;

import com.covid.exception.AppointmentException;
import com.covid.model.Appointment;
import com.covid.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;


    @Override//ADMIN
    public List<Appointment> getAllAppointment() throws AppointmentException {
        return null;
    }

    @Override//USER
    public Appointment getAppointment(long bookingid) throws AppointmentException {
        //if(appointmentRepo
        return null;
    }

    @Override//USER
    public Appointment addAppointment(Appointment app) throws AppointmentException {
        return null;
    }

    @Override//USER
    public Appointment updateAppointment(Appointment app) throws AppointmentException {
        return null;
    }

    @Override//USER
    public boolean deleteAppointment(Appointment app) throws AppointmentException {
        return false;
    }
}
