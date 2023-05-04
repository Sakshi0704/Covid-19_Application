package com.covid.service;

import com.covid.exception.AppointmentException;
import com.covid.model.Appointment;

import java.util.List;

public interface AppointmentService {


    public List<Appointment> getAllAppointment()throws AppointmentException;

    public Appointment getAppointment(long bookingid) throws AppointmentException;

    public Appointment addAppointment(Appointment app)throws AppointmentException;

    public Appointment updateAppointment(Appointment app)throws AppointmentException;

    public boolean deleteAppointment(Appointment app)throws AppointmentException;

}
