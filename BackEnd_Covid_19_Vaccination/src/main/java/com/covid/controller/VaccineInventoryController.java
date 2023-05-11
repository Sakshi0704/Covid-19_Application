package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.VaccinationCentre;
import com.covid.model.Vaccine;
import com.covid.model.VaccineInventory;
import com.covid.repository.VaccinationCentreRepository;
import com.covid.repository.VaccineInventoryRepository;
import com.covid.repository.VaccineRepository;

@RestController
public class VaccineInventoryController {

    @Autowired
    private VaccineInventoryRepository vaccineInventoryRepository;

    @Autowired
    private VaccineRepository vaccineRepository ;

    @Autowired
    private VaccinationCentreRepository vaccinationCentreRepository;

    @GetMapping("/vaccineinventory")
    public List<VaccineInventory> getAllVaccineInventory(){
        List<VaccineInventory> list= vaccineInventoryRepository.findAll();
        return list;
    }
    

    @PostMapping("/vaccineinventory/{vaccinename}/{vaccinationcentreid}")
    public VaccineInventory addVaccineInventory(@PathVariable String vaccinename, @PathVariable Long vaccinationcentreid, @RequestBody VaccineInventory vaccineInventory){
      Vaccine vaccine = vaccineRepository.findByVaccineName(vaccinename);
       // vaccineInventory.getVaccinelist().addAll(list);
       VaccinationCentre vaccinationCenter = vaccinationCentreRepository.findById(vaccinationcentreid).get();
       vaccineInventory.getVaccinelist().add(vaccine);
       vaccineInventory.setVaccinationCenter(vaccinationCenter);
        return vaccineInventoryRepository.save(vaccineInventory);
    }
}