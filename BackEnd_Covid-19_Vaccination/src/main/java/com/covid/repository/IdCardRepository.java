// package com.covid.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.PagingAndSortingRepository;
// import org.springframework.stereotype.Repository;

// import com.covid.model.IdCard;

// @Repository
// public interface IdCardRepository extends JpaRepository<IdCard, Integer>, PagingAndSortingRepository<IdCard, Integer>{
	
// 	@Query("from IdCard i where i.adharCard.adharNumber = ?1")
// 	public IdCard getAdharByNumber(Long adharNumber);
// }



package com.covid.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.covid.model.IdCard;
import com.covid.model.IdProof;

@Repository
public interface IdCardRepository extends JpaRepository<IdCard, Integer> {

//    public IdProof save(IdProof idproof);

   @Query("SELECT i.idProof FROM IdCard i WHERE i.idProof.idNumber = :idNumber")
   public IdProof findByIdNumber(@Param("idNumber") String idNumber);


   // @Query("SELECT i.idCard FROM IdCard i WHERE i.idProof.idNumber = :idNumber")
   //  public IdCard findByIdProofIdNumber(@Param("idNumber") String idNumber);
//  // public IdProof findByIdNumber(String idNumber);

//   public List<IdCard> findAllByMainuser(MainUser mainUser);
   
//    // public IdProof findByIdNumber(String idNumber);

//   //public List<IdCard> findByUserMobile();

// //   @Query("SELECT ic FROM IdCard ic WHERE ic.mainuser.userMobile = :userMobile")
// // List<IdCard> findByUserMobile(@Param("userMobile") String mobile);

}
