package org.doctorapp;

import java.util.Scanner;

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

		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose from the below options");
        System.out.println("1. Update  \n" +
                "2. Delete  \n" +
                "3. List of All doctors details  \n" +
                "4. Find by speciality  \n" +
                "5. Find by speciality and Experience  \n" +
                "6. Find by speciality and Ratings  \n" +
                "7. Find by speciality and Fees  \n" +
                "8. Find by speciality and Name  \n" +
                "9. Find by DoctorId  \n" +
                "10. Add new Doctor \n" +
                "11. Exit \n");
		System.out.println("Enter your choice");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter the details to update");
			System.out.println("Enter doctorId");
			int doctorId = scanner.nextInt();
			System.out.println("Enter the Fees to update");
			double fees = scanner.nextDouble();
			doctorService.updateDoctor(doctorId, fees);
			break;

		case 2:
			System.out.println("Enter the details to delete");
			System.out.println("Enter doctorId");
			int UpdateDoctorId = scanner.nextInt();
			doctorService.deleteDoctor(UpdateDoctorId);
			break;

		case 3:
			System.out.println("Finding all doctor details");
			for (Doctor doc : doctorService.getAll())
				System.out.println(doc);
			break;

		case 4:
			System.out.println("Finding the doctors by speciality");
			System.out.println("Enter Doctor Speciality");
			String findBySpeciality = scanner.next();
			for (Doctor doc : doctorService.getBySpeciality(findBySpeciality))
				System.out.println(doc);
			break;

		case 5:
			System.out.println("Enter details to find the doctor by Speciality and Experience");
			System.out.println("Enter Speciality");
			String findBySpec = scanner.next();
			System.out.println("Enter Experience");
			int findByExperience = scanner.nextInt();
			for (Doctor doc : doctorService.getBySpecialityAndExp(findBySpec, findByExperience))
				System.out.println(doc);
			break;

		case 6:
			System.out.println("Enter details to find the doctor by Speciality and Ratings");
			System.out.println("Enter Speciality");
			String findBySpecialty = scanner.next();
			System.out.println("Enter Ratings");
			int findByRatings = scanner.nextInt();
			for (Doctor doc : doctorService.getBySpecialityAndRatings(findBySpecialty, findByRatings))
				System.out.println(doc);
			break;

		case 7:
			System.out.println("Enter details to find the doctor by speciality and Fees");
			System.out.println("Enter Speciality");
			String findBySpecialityAndFees = scanner.next();
			System.out.println("Enter Fees");
			double findByFees = scanner.nextDouble();
			for (Doctor doc : doctorService.getBySpecialityAndLessFees(findBySpecialityAndFees, findByFees))
				System.out.println(doc);
			break;

		case 8:
			System.out.println("Enter details to find the doctor by speciality and Name");
			System.out.println("Enter Speciality");
			String doctorSpeciality = scanner.next();
			System.out.println("Enter Doctor name");
			String doctorName = scanner.next();
			for (Doctor doc : doctorService.getBySpecialityAndName(doctorSpeciality, doctorName))
				System.out.println(doc);
			break;

		case 9:
			System.out.println("Enter the details to find doctor");
			System.out.println("Enter doctor Id");
			int findByDoctorId = scanner.nextInt();
			Doctor doctor1 = doctorService.getById(findByDoctorId);
			System.out.println(doctor1);
			break;
		case 10:
			System.out.println("Enter Doctor name");
			String doctorName1 = scanner.next();
			System.out.println("Enter Speciality");
			String Speciality = scanner.next();
			System.out.println("Enter Experience");
			int Experience = scanner.nextInt();
			System.out.println("Enter Ratings");
			int ratings = scanner.nextInt();
			System.out.println("Enter Fees");
			double fees1 = scanner.nextDouble();
			Doctor doctor = new Doctor(doctorName1, Speciality, fees1, ratings, Experience);
			doctorService.addDoctor(doctor);
		case 11:
			System.exit(1);
		default:
			System.out.println("\nInvalid choice\n");
		}
		scanner.close();
	}
}
