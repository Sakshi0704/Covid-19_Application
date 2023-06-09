package com.covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class Covid19VaccinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19VaccinationApplication.class, args);
	}

}
