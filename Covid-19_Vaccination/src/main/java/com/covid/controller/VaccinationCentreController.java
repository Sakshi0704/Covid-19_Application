package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.VaccinationCentre;
import com.covid.service.VaccinationCentreService;

@Controller
public class VaccinationCentreController {
  
    @Autowired
    private VaccinationCentreService vaccinationCentreService;

    @GetMapping("/vaccinationCentres")
    public String listOfVaccinationCentre(Model model){

        model.addAttribute("vaccinationCentres", vaccinationCentreService.getAllVaccinationCentre());
   return "vaccinationCentres";
    }

    @GetMapping("/vaccinationCentres/new")
    public String createVaccinationCentre(Model model){
        VaccinationCentre vaccinationcentre=new VaccinationCentre();
        model.addAttribute("vaccinationcentre", vaccinationcentre);

        return "createVaccinationCentre";
    }
    


    @PostMapping("/vaccinationCentres")
    public String saveVaccinationCentre(@ModelAttribute("vaccinationcentre") VaccinationCentre vaccinationcentre){

        vaccinationCentreService.saveVaccinationCentre(vaccinationcentre);
        return "redirect:/vaccinationCentres";
    }

    @GetMapping("/vaccinationCentres/edit/{centreId}")
    public String editVaccinationCentre(@PathVariable Long centreId, Model model){

        model.addAttribute("vaccinationcentre", vaccinationCentreService.getVaccinationCentreById(centreId));
   return "editVaccinationCentre";
    }


    @PostMapping("vaccinationCentres/{centreId}")
    public String updateVaccinationCentre(@PathVariable Long centreId, 
    @ModelAttribute("vaccinationcentre") VaccinationCentre vaccinationcentre,
    Model model){

        VaccinationCentre existingVaccinationCentre = vaccinationCentreService.getVaccinationCentreById(centreId);
        existingVaccinationCentre.setCentreId(centreId);
        existingVaccinationCentre.setState(vaccinationcentre.getState());
        existingVaccinationCentre.setCity(vaccinationcentre.getCity());
        existingVaccinationCentre.setLocality(vaccinationcentre.getLocality());
        existingVaccinationCentre.setPincode(vaccinationcentre.getPincode());
        vaccinationCentreService.updateVaccinationCentre(existingVaccinationCentre);

        return "redirect:/vaccinationCentres";
    }


    @GetMapping("/vaccinationCentres/{centreId}")
    public String deleteVaccinationCentre(@PathVariable Long centreId){
        vaccinationCentreService.deleteVaccinationCentreById(centreId);
        return "redirect:/vaccinationCentres";
    }


}