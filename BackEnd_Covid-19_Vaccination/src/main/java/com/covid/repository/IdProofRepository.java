package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.IdProof;

@Repository
public interface IdProofRepository extends JpaRepository<IdProof, Integer>{

    public IdProof findByIdNumber(String idNumber);
    
}