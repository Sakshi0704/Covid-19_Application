// package com.covid.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.covid.exception.AdharCardException;
// import com.covid.exception.IdCardException;
// import com.covid.model.IdCard;
// import com.covid.model.IdProof;
// import com.covid.model.MainUser;
// import com.covid.repository.IdCardRepository;
// import com.covid.repository.IdProofRepository;
// import com.covid.repository.MainUserRepository;

// // public interface IdCardService {
// // 	public IdCard saveIdCard(IdCard idCard);

// //     public IdProof saveIdProof(IdProof idproof);

// //     public List<IdCard> getAllIdCards();

// //     public Optional<IdCard> getIdCardById(Integer id);
// //    // IdCard findByUserMobile(String mobile);
// //     //public Optional<IdCard> getIdCardByIdProof(IdProof idProof);
// //     public List<IdCard> findByMobile(String mobile);
// //     public void deleteIdCard(Integer id);

// //     public void updateIdCard(Integer id, IdCard idCard);
// // }


// @Service
// public class IdCardService {

//     @Autowired
//     private IdCardRepository idCardRepository;

//     @Autowired
//     private MainUserRepository mainUserRepository;

//     @Autowired
//     private IdProofRepository idProofRepository;

//     public IdCard addIdCard(IdCard idcard){
//         idProofRepository.save(idcard);
//     }

  
//     public IdCard saveOrUpdate(IdCard idCard, Integer mainUserId) {
//         MainUser mainUser = mainUserRepository.findById(mainUserId).get();//;.orElseThrow(() -> new ResourceNotFoundException("Main user not found with id: " + mainUserId));
//         idCard.setMainuser(mainUser);
//         IdProof idProof = idCard.getIdProof();
//         if (idProof != null) {
//             idProof = idProofRepository.save(idProof);
//             idCard.setIdProof(idProof);
//         }
//         return idCardRepository.save(idCard);
//     }

   
//     public List<IdCard> getAllIdCardsByMainUserId(Integer mainUserId) {
//         MainUser mainUser = mainUserRepository.findById(mainUserId).get();//.orElseThrow(() -> new ResourceNotFoundException("Main user not found with id: " + mainUserId));
//         return idCardRepository.findAllByMainuser(mainUser);
//     }

   
//     public IdCard getIdCardById(Integer idCardId) {
//         return idCardRepository.findById(idCardId).get();//.orElseThrow(() -> new ResourceNotFoundException("Id card not found with id: " + idCardId));
//     }

   
//     public void deleteIdCardById(Integer idCardId) {
//         IdCard idCard = idCardRepository.findById(idCardId).get();//.orElseThrow(() -> new ResourceNotFoundException("Id card not found with id: " + idCardId));
//         idCardRepository.delete(idCard);
//     }
// }
