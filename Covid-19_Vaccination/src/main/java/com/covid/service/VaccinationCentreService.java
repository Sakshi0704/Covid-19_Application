package com.covid.service;

import java.util.*;

import com.covid.entities.VaccinationCentre;

public interface VaccinationCentreService {

   public List<VaccinationCentre> getAllVaccinationCentre();
   public VaccinationCentre saveVaccinationCentre(VaccinationCentre vaccinationcentre);
   public VaccinationCentre getVaccinationCentreById(Long centreId);
   public VaccinationCentre updateVaccinationCentre(VaccinationCentre vaccinationcentre);
   public void deleteVaccinationCentreById(Long centreId);

}