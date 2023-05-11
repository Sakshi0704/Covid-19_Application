package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.Vaccine;
import com.covid.model.VaccineCount;
import com.covid.repository.VaccineCountRepository;
import com.covid.repository.VaccineRepository;

@RestController
public class VaccineCountController {

    @Autowired
    private VaccineCountRepository vaccineCountRepository;

    @Autowired
    private VaccineRepository vaccineRepository ;

    @GetMapping("/vaccinecount")
    private List<VaccineCount> getAllVaccineCount(){
        List<VaccineCount> list = vaccineCountRepository.findAll();
        return list;
    }

    @PostMapping("/vaccinecount/{vaccinename}")
    private VaccineCount addVaccineCount(@PathVariable String vaccinename,  @RequestBody VaccineCount vaccineCount){
       Vaccine vaccine = vaccineRepository.findByVaccineName(vaccinename);
      System.out.println("======================================");
       vaccineCount.setVaccine(vaccine);
       return  vaccineCountRepository.save(vaccineCount);
       
    }
    
}