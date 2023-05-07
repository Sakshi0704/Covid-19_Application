package com.covid.service;

import com.covid.exception.AppointmentException;
import com.covid.model.Appointment;
import com.covid.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;


    @Override//ADMIN
    public List<Appointment> getAllAppointment() throws AppointmentException {
        List<Appointment> list = appointmentRepo.findAll();
        if(list.isEmpty()) throw new AppointmentException("Appointment list is empty");
        else return list;
    }

    @Override//USER
    public Appointment getAppointment(long bookingid) throws AppointmentException {
        // Check if it exists or not
        Optional<Appointment> appointment = appointmentRepo.findById(bookingid);
        if(appointment.isEmpty()) throw new AppointmentException("Booking Id doesn't exist. ");
        else return appointment.get();
    }

    @Override//USER
    public Appointment addAppointment(Appointment app) throws AppointmentException {

        // CHECK IF IT EXIST OR NOT
        Optional<Appointment> check = appointmentRepo.findById(app.getBookingid());
        if(check.isPresent()) throw new AppointmentException("Appointment exists with Id: "+app.getBookingid());

        appointmentRepo.save(app);

        return app;
    }

    @Override//USER
    public Appointment updateAppointment(Appointment app) throws AppointmentException {

        // CHECK IF ID IS CORRECT
        Optional<Appointment> checked = appointmentRepo.findById(app.getBookingid());

        if(checked.isEmpty()) throw new AppointmentException("Appointment Not exist");

        appointmentRepo.save(app);
        return app;
    }

    @Override//USER
    public boolean deleteAppointment(Appointment app) throws AppointmentException {

        // CHECK IF ID IS CORRECT
        Optional<Appointment> checked = appointmentRepo.findById(app.getBookingid());

        if(checked.isEmpty()) throw new AppointmentException("Appointment Not exist");

        // If booking status is false
        if(!checked.get().isBookingstatus()) throw new AppointmentException("Cannot delete appointment as appointment was not booked");

        appointmentRepo.delete(app);
        return true;
    }
}
