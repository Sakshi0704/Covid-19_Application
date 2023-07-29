package com.covid.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "VACCINECOUNT")
public class VaccineCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaccinecountId;

    @OneToOne(cascade = CascadeType.ALL)
    private VaccineInventory vaccineInventory;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "VaccineCount")
//    private List<Vaccine> vaccineList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private VaccinationCentre vaccinationCentre;

    @OneToOne(cascade = CascadeType.ALL)
    private Vaccine vaccine;

    private Integer quantity;

    private Integer price;
}
