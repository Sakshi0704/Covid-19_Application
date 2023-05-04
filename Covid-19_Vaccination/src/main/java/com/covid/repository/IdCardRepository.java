package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.IdCard;

@Repository
public interface IdCardRepository extends JpaRepository<IdCard, Integer>, PagingAndSortingRepository<IdCard, Integer>{
	
	@Query("from IdCard i where i.adharCard.adharNumber = ?1")
	public IdCard getAdharByNumber(Long adharNumber);
}
