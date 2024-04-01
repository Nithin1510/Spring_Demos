package org.doctorapp;

import org.doctorapp.model.Doctor;
import org.doctorapp.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDoctorappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappJdbcApplication.class, args);
	}

	@Autowired
	IDoctorService doctorService;

	@Override
	public void run(String... args) throws Exception {
		
//		String speciality = Specialization

		System.out.println("Finding all doctor details");
		for (Doctor doc : doctorService.getAll())
			System.out.println(doc);

	}
}
