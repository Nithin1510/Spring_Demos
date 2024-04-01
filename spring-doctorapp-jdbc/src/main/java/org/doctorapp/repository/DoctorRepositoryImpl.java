package org.doctorapp.repository;

import org.doctorapp.model.Doctor;
import org.doctorapp.util.Queries;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepositoryImpl implements IDoctorRepository {

	private JdbcTemplate jdbcTemplate;
	
	public DoctorRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addDoctor(Doctor doctor) {
		Object[] doctorAdd = {doctor.getDoctorId(), doctor.getDoctorName(), doctor.getSpeciality(), doctor.getExperience(), doctor.getRatings(), doctor.getFees()};
		jdbcTemplate.update(Queries.InsertQuery, doctorAdd);
	}

	@Override
	public void updateDoctor(int doctorId, double fees) {
		jdbcTemplate.update(Queries.UpdateQuery, fees);
	}

	@Override
	public void deleteDoctor(int doctorId) {
		jdbcTemplate.update(Queries.DeleteQuery, doctorId);
	}

	@Override
	public Doctor findById(int doctorId) {
		Doctor doctor = jdbcTemplate.queryForObject(Queries.findById, Doctor.class, doctorId);
		return doctor;
	}

	@Override
	public List<Doctor> findAll() {
		RowMapper<Doctor> mapper = new DoctorMapper();
		List<Doctor> doctors = jdbcTemplate.query(Queries.findAllQuery, mapper);
		return doctors;
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) {
		List<Doctor> doctors = jdbcTemplate.query(Queries.findBySpeciality, new DoctorMapper(), speciality);
		return doctors;
	}

	@Override
	public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {
		List<Doctor> doctors = jdbcTemplate.query(Queries.findBySpecAndExp, new DoctorMapper(), speciality, experience);
		return doctors;
	}

	@Override
	public List<Doctor> findBySpecialityAndLessFees(String speciality, double fees) {
		List<Doctor> doctors = jdbcTemplate.query(Queries.findBySpecAndFees, new DoctorMapper(), speciality, fees);
		return doctors;
	}

	@Override
	public List<Doctor> findBySpecialityAndRatings(String speciality, int ratings) {
		List<Doctor> doctors = jdbcTemplate.query(Queries.findBySpecAndRatings, new DoctorMapper(), speciality, ratings);
		return doctors;
	}

	@Override
	public List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName) {
		List<Doctor> doctors = jdbcTemplate.query(Queries.findBySpecAndName, new DoctorMapper(), speciality, doctorName);
		return doctors;
	}
   
}
