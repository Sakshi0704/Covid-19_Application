package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.IdCard;

@Repository
public interface IdCardRepo extends JpaRepository<IdCard, Integer>{

}
