// package com.covid.service;

// import java.util.List;
// import java.util.Optional;
// import java.util.Set;
// import java.util.function.Supplier;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import com.covid.exception.*;
// import com.covid.model.IdCard;
// import com.covid.model.MainUser;
// import com.covid.repository.MainUserRepository;

// // public interface MainUserService {

// //    public MainUser addUser(String mobileNumber, MainUser mainuser);

// //   public MainUser addMainUser(MainUser mainUser);

// //   public List<MainUser> getAllUsers();

// //     public MainUser findUserByuserMobile(String userMobile);
    
// // }


// @Service
// public class MainUserService {

//     @Autowired
//     private MainUserRepository mainUserRepository;

//     public List<MainUser> getAllMainUsers() {
//         return mainUserRepository.findAll();
//     }

//     public MainUser getMainUserById(Integer id) {
//         return mainUserRepository.findById(id).get();
                
//     }

//     public MainUser createMainUser(MainUser mainUser) {
//         return mainUserRepository.save(mainUser);
//     }

//     public MainUser updateMainUser(Integer id, MainUser mainUserDetails) {
//         MainUser mainUser = mainUserRepository.findById(id).get();
//               //  .orElseThrow(() -> new ResourceNotFoundException("Main User not found with id: " + id));

//         mainUser.setUserMobile(mainUserDetails.getUserMobile());

//         MainUser updatedMainUser = mainUserRepository.save(mainUser);
//         return updatedMainUser;
//     }

//     public ResponseEntity<?> deleteMainUser(Integer id) {
//         MainUser mainUser = mainUserRepository.findById(id).get();
//                 //.orElseThrow(() -> new ResourceNotFoundException("Main User not found with id: " + id));

//         mainUserRepository.delete(mainUser);

//         return ResponseEntity.ok().build();
//     }

//     public Set<IdCard> getAllIdCardsByMainUserId(Integer mainUserId) {
//         MainUser mainUser = mainUserRepository.findById(mainUserId).get();
//                 //.orElseThrow(() -> new ResourceNotFoundException("Main User not found with id: " + mainUserId));

//         return mainUser.getIdCardSet();
//     }

//     public IdCard createIdCard(Integer mainUserId, IdCard idCard) {
//         MainUser mainUser = mainUserRepository.findById(mainUserId).get();
//                // .orElseThrow(() -> new ResourceNotFoundException("Main User not found with id: " + mainUserId));

//         idCard.setMainuser(mainUser);
//         return mainUserRepository.save(mainUser).getIdCardSet().stream()
//                 .filter(card -> card.getName().equals(idCard.getName()))
//                 .findFirst()
//                 .orElseThrow(() -> new RuntimeException("Error creating Id Card"));
//     }

//     // public IdCard updateIdCard(Integer id, IdCard idCardDetails) {
//     //     IdCard idCard = mainUserRepository.findIdCardById(id);
//     //            // .orElseThrow(() -> new ResourceNotFoundException("Id Card not found with id: " + id));



//     //     idCard.setName(idCardDetails.getName());
//     //     idCard.setDateOfBirth(idCardDetails.getDateOfBirth());
//     //     idCard.setGender(idCardDetails.getGender());
//     //     idCard.setLocality(idCardDetails.getLocality());
//     //     idCard.setCity(idCardDetails.getCity());
//     //     idCard.setState(idCardDetails.getState());
//     //     idCard.setPincode(idCardDetails.getPincode());


//     //     IdCard updatedIdCard = mainUserRepository.save(idCard);

//     //     return updatedIdCard;
//     // }

//     // public ResponseEntity<?> deleteIdCard(Integer id) {
//     //     IdCard idCard = mainUserRepository.findIdCardById(id);
//     //            // .orElseThrow(() -> new ResourceNotFoundException("Id Card not found with id: " + id));

//     //     mainUserRepository.deleteById(id);

//     //     return ResponseEntity.ok().build();
//     // }
// }
