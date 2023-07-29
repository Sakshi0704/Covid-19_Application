package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.exception.MemberException;
import com.covid.exception.VaccineRegistrationException;
import com.covid.model.Member;
import com.covid.model.VaccineRegistration;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{


}
