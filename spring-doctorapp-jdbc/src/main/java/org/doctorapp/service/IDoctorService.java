package org.doctorapp.service;

import org.doctorapp.exceptions.DoctorNotFoundException;
import org.doctorapp.exceptions.IdNotFoundException;
import org.doctorapp.model.Doctor;

import java.util.List;

public interface IDoctorService {

    void addDoctor(Doctor doctor);

    void updateDoctor(int doctorId, double fees);

    void deleteDoctor(int doctorId);

    Doctor getById(int doctorId) throws IdNotFoundException;

    List<Doctor> getAll();

    List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException;

    List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException;

    List<Doctor> getBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException;

    List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException;

    List<Doctor> getBySpecialityAndName(String speciality, String doctorName) throws DoctorNotFoundException;


}
