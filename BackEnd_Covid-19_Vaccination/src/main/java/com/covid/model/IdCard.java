package com.covid.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class IdCard { // adding a member... there we have to give idProof

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id; // refId

	@NotBlank(message = "Name should not be blank")
	@NotEmpty(message = "")
	@NotNull
	@Size(min = 2, max = 25)
	private String name;

	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	// @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}")
	private String dateOfBirth;

   @Enumerated(EnumType.STRING)
	private String gender;

//	private String mobile;

	private String locality;

	private String city;

	private String state;

	private String pincode;

	 @OneToOne
	 private Member member;

	 @OneToOne(cascade = CascadeType.ALL)
	 private IdProof idProof;

	 @ManyToOne(cascade = CascadeType.ALL)
	 private MainUser mainuser;

//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "idcard")
//	private List<Appointment> appointments = new ArrayList<>();
}
