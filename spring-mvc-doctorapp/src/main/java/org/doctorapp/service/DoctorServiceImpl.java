package org.doctorapp.service;

import org.doctorapp.exceptions.DoctorNotFoundException;
import org.doctorapp.exceptions.IdNotFoundException;
import org.doctorapp.model.Doctor;
import org.doctorapp.repository.DoctorRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	DoctorRepositoryImpl DoctorRepository;
	@Override
	public void addDoctor(Doctor doctor) {
		DoctorRepository.addDoctor(doctor);		
	}

	@Override
	public void updateDoctor(int doctorId, double fees) {
		DoctorRepository.updateDoctor(doctorId, fees);
	}

	@Override
	public void deleteDoctor(int doctorId) {
		DoctorRepository.deleteDoctor(doctorId);
	}

	@Override
	public Doctor getById(int doctorId) throws IdNotFoundException {
		Doctor doctor = DoctorRepository.findById(doctorId);
		if(doctor == null)
			throw new IdNotFoundException("Doctor not found with Id");
		return doctor;
	}

	@Override
	public List<Doctor> getAll() {
		List<Doctor> doctors = DoctorRepository.findAll();
		return doctors;
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {
		List<Doctor> doctorList = DoctorRepository.findBySpeciality(speciality);
		if(doctorList.isEmpty()) 
			throw new DoctorNotFoundException("Doctor not found with this speciality.");
		Collections.sort(doctorList, (d1,d2) -> d1.getDoctorName().compareTo(d2.getDoctorName()));
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
		List<Doctor> doctorList = DoctorRepository.findBySpecialityAndExp(speciality, experience);
		if(doctorList.isEmpty()) 
			throw new DoctorNotFoundException("Doctor not found with this speciality and experience.");
		 Collections.sort(doctorList, (d1,d2) -> ((Integer)d2.getExperience()).compareTo(d1.getExperience()));
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException {
		List<Doctor> doctorList = DoctorRepository.findBySpecialityAndLessFees(speciality, fees);
		if(doctorList.isEmpty()) 
			throw new DoctorNotFoundException("Doctor not found with this speciality and fees.");
		 Collections.sort(doctorList, (d1,d2) -> ((Double)d1.getFees()).compareTo(d2.getFees()));
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException {
		List<Doctor> doctorList = DoctorRepository.findBySpecialityAndRatings(speciality, ratings);
		if(doctorList.isEmpty()) 
			throw new DoctorNotFoundException("Doctor not found with this speciality and ratings.");
		Collections.sort(doctorList, (d1,d2) -> ((Integer)d1.getRatings()).compareTo(d2.getRatings()));
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndName(String speciality, String doctorName) throws DoctorNotFoundException {
		List<Doctor> doctorList = DoctorRepository.findBySpecialityAndNameContains(speciality, doctorName);
		if(doctorList.isEmpty()) 
			throw new DoctorNotFoundException("Doctor not found with this speciality and name.");
		Collections.sort(doctorList, (d1,d2) -> (d2.getDoctorName()).compareTo(d1.getDoctorName()));
		return doctorList;
	}

    
}
