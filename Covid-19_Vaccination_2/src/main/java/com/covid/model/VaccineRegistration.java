package com.covid.model;


import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
public class VaccineRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer regId;

    @NotNull
    @Pattern(regexp = "[7-9]{1}[0-9]{9}", message = "Please Enter a Valid Mobile Number")
    @Column(unique = true,length = 10)
    private String mobile;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "vaccineRegistration")
    private List<Member> members = new ArrayList<>();

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfRegistration;
}
