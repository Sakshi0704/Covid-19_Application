package com.covid.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class BlockedAppointments {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer blockedid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Member member;

}
