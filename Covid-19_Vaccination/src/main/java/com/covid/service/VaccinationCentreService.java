package com.covid.service;

import java.util.*;

import com.covid.model.VaccinationCentre;

public interface VaccinationCentreService {

   public List<VaccinationCentre> getAllVaccinationCentre();
   public VaccinationCentre saveVaccinationCentre(VaccinationCentre vaccinationcentre);
   public VaccinationCentre getVaccinationCentreById(Long centreId);
   public VaccinationCentre updateVaccinationCentre(VaccinationCentre vaccinationcentre);
   public void deleteVaccinationCentreById(Long centreId);

}