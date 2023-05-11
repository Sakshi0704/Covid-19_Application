// package com.covid.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.covid.model.MainUser;
// import com.covid.repository.MainUserRepository;

// // @Service
// // public class MainUserServiceImpl implements MainUserService{

//     @Autowired
//     private MainUserRepository  mainUserRepository;

// //     @Override
// //     public MainUser addUser(String mobileNumber, MainUser mainuser) {
// //         MainUser existingUser = mainUserRepository.findUserByuserMobile(mobileNumber);
// //         if (existingUser == null) {
       
// //             MainUser user= mainUserRepository.save(mainuser);
// //             System.out.println(user+"============================ Yes");
// //             return user;
// //     }
// //     System.out.println(existingUser+"============================== Not ");
// //     return null;
// // }

// //     @Override
// //     public MainUser findUserByuserMobile(String userMobile) {
// //         System.out.println("======================service");
// //         return mainUserRepository.findUserByuserMobile(userMobile);
// //     }

// //     @Override
// //     public MainUser addMainUser(MainUser mainUser) {
// //         MainUser m= mainUserRepository.save(mainUser);
// //         return m;

// //     }

// //     @Override
// //     public List<MainUser> getAllUsers() {
// //         List<MainUser> listOfAllUsers = mainUserRepository.findAll();
// //         return listOfAllUsers;
// //     }

   

// //     // @Override
// //     // public MainUser findByMobileNumber(String mobileNumber) throws Exception {
        
// //     //     MainUser existingUser = mainUserRepository.findByUserByMobile(mobileNumber);
// //     //     if (existingUser == null) {
// //     //         return existingUser;
// //     //     }

// //     //     else{
// //     //         mainUserRepository.save(null)
// //     //     }
       
   
// //     // }
    
// // }



// @Service
// public class MainUserService {

//     @Autowired
//     private MainUserRepository mainUserRepository;

//     public List<MainUser> getAllMainUsers() {
//         return mainUserRepository.findAll();
//     }

//     public MainUser getMainUserById(Integer id) {
//         return mainUserRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Main User not found with id: " + id));
//     }

//     public MainUser createMainUser(MainUser mainUser) {
//         return mainUserRepository.save(mainUser);
//     }

//     public MainUser updateMainUser(Integer id, MainUser mainUserDetails) {
//         MainUser mainUser = mainUserRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Main User not found with id: " + id));

//         mainUser.setUserMobile(mainUserDetails.getUserMobile());

//         MainUser updatedMainUser = mainUserRepository.save(mainUser);
//         return updatedMainUser;
//     }

//     public ResponseEntity<?> deleteMainUser(Integer id) {
//         MainUser mainUser = mainUserRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Main User not found with id: " + id));

//         mainUserRepository.delete(mainUser);

//         return ResponseEntity.ok().build();
//     }

//     public Set<IdCard> getAllIdCardsByMainUserId(Integer mainUserId) {
//         MainUser mainUser = mainUserRepository.findById(mainUserId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Main User not found with id: " + mainUserId));

//         return mainUser.getIdCardSet();
//     }

//     public IdCard createIdCard(Integer mainUserId, IdCard idCard) {
//         MainUser mainUser = mainUserRepository.findById(mainUserId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Main User not found with id: " + mainUserId));

//         idCard.setMainuser(mainUser);
//         return mainUserRepository.save(mainUser).getIdCardSet().stream()
//                 .filter(card -> card.getName().equals(idCard.getName()))
//                 .findFirst()
//                 .orElseThrow(() -> new RuntimeException("Error creating Id Card"));
//     }

//     public IdCard updateIdCard(Integer id, IdCard idCardDetails) {
//         IdCard idCard = mainUserRepository.findIdCardById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Id Card not found with id: " + id));

//         idCard.setName(idCardDetails.getName());
//         idCard.setDateOfBirth(idCardDetails.getDateOfBirth());
//         idCard.setGender(idCardDetails.getGender());
//         idCard.setLocality(idCardDetails.getLocality());
//         idCard.setCity(idCardDetails.getCity());
//         idCard.setState(idCardDetails.getState());
//         idCard.setPincode(idCardDetails.getPincode());

//         IdCard updatedIdCard = mainUserRepository.save(idCard);
//         return updatedIdCard;
//     }

//     public ResponseEntity<?> deleteIdCard(Integer id) {
//         IdCard idCard = mainUserRepository.findIdCardById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Id Card not found with id: " + id));

//         mainUserRepository.delete(idCard);

//         return ResponseEntity.ok().build();
//     }
// }
