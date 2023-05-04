package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.covid.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>, PagingAndSortingRepository<Member, Integer>{
	
	@Query("select m from Member m where m.idCard.adharCard.adharNumber = :aNumber")
	public Member findMemberByAdharNumber(@Param("aNumber") Long adharNumber);
}
