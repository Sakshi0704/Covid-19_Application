// package com.covid.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.covid.model.VaccinationCentre;
// import com.covid.repository.VaccinationCentreRepository;

// @Service
// public class VaccinationCentreServiceImpl implements VaccinationCentreService{


//     @Autowired
//     private VaccinationCentreRepository vaccinationCentreRepository;
   
//     @Override
//     public List<VaccinationCentre> getAllVaccinationCentre() {
//        return vaccinationCentreRepository.findAll();
//     }

//     @Override
//     public VaccinationCentre saveVaccinationCentre(VaccinationCentre vaccinationcentre) {
       
//         VaccinationCentre vc= vaccinationCentreRepository.save(vaccinationcentre);
    
//     return vc;
// }

//     @Override
//     public VaccinationCentre getVaccinationCentreById(Long centreId) {
//        return vaccinationCentreRepository.findById(centreId).get();
//     }

//     @Override
//     public VaccinationCentre updateVaccinationCentre(VaccinationCentre vaccinationcentre) {
//         return vaccinationCentreRepository.save(vaccinationcentre);
//     }

//     @Override
//     public void deleteVaccinationCentreById(Long centreId) {
//         vaccinationCentreRepository.deleteById(centreId);
//     }
    
// }