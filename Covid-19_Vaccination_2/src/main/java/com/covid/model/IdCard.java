package com.covid.model;

import lombok.Getter;
import lombok.Setter;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.*;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "IDCARD")
public class IdCard {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotEmpty
    private String name;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate dob;

    
    
    private String gender;

    
    private String address;
    
    
    private String city;
    
    private String state;
    
    @Pattern(regexp = "[0-9]{6}", message = "Please Enter a Valid pincode")
    private String pincode;

    
    @NotNull
    @Pattern(regexp = "[1-9]{1}[0-9]{11}", message = "Please Enter a Valid aadhar no")
    @Column(unique = true)
    private String aadharNo;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "idCard")
    private Member member;


}
