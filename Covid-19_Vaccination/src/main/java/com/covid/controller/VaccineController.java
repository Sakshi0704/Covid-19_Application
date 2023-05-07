package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.covid.exception.VaccineException;
import com.covid.model.Vaccine;
import com.covid.service.VaccineService;

public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping("/vaccines")
    public String listVaccines(Model model) {
        try {
            List<Vaccine> vaccines = vaccineService.getAllService();
            model.addAttribute("vaccines", vaccines);
        } catch (VaccineException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "vaccineList";
    }

    @GetMapping("/vaccines/{vaccineId}")
    public String showVaccine(@PathVariable Integer vaccineId, Model model) {
        try {
            Vaccine vaccine = vaccineService.getVaccineById(vaccineId);
            model.addAttribute("vaccine", vaccine);
        } catch (VaccineException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "vaccineDetails";
    }

    @GetMapping("/vaccines/new")
    public String createVaccineForm(Model model) {
        Vaccine vaccine = new Vaccine();
        model.addAttribute("vaccine", vaccine);
        return "vaccineForm";
    }

    @PostMapping("/vaccines/new")
    public String createVaccine(@ModelAttribute Vaccine vaccine, Model model) {
        try {
            vaccineService.registerNewVaccine(vaccine);
        } catch (VaccineException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("vaccine", vaccine);
            return "vaccineForm";
        }
        return "redirect:/vaccines";
    }

    @GetMapping("/vaccines/edit/{vaccineId}")
    public String editVaccineForm(@PathVariable Integer vaccineId, Model model) {
        try {
            Vaccine vaccine = vaccineService.getVaccineById(vaccineId);
            model.addAttribute("vaccine", vaccine);
        } catch (VaccineException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "vaccineForm";
    }

    @PostMapping("/vaccines/edit/{vaccineId}")
    public String updateVaccine(@PathVariable Integer vaccineId, @ModelAttribute Vaccine vaccine, Model model) {
        try {
            Vaccine existingVaccine = vaccineService.getVaccineById(vaccineId);
            existingVaccine.setVaccineName(vaccine.getVaccineName());
            existingVaccine.setDescription(vaccine.getDescription());
            // existingVaccine.setVaccineCount(vaccine.getVaccineCount());
            // existingVaccine.setMember(vaccine.getMember());
            vaccineService.updateVaccine(existingVaccine);
        } catch (VaccineException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("vaccine", vaccine);
            return "vaccineForm";
        }
        return "redirect:/vaccines";
    }

    @GetMapping("/vaccines/delete/{vaccineId}")
    public String deleteVaccine(@PathVariable Integer vaccineId, Model model) {
        try {
            Vaccine vaccine = vaccineService.getVaccineById(vaccineId);
            vaccineService.deleteVaccine(vaccine);
        } catch (VaccineException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/vaccines";
    }

    
}