package org.doctorapp.util;

public class Queries {
    public static final String InsertQuery= "INSERT INTO doctor(doctor_name, speciality, fees, ratings, experience) VALUES (?, ?, ?, ?, ?)";
    public static final String UpdateQuery= "UPDATE doctor SET fees=? WHERE doctor_id=?;";
    public static final String DeleteQuery= "DELETE FROM doctor WHERE doctor_id=?;";

    public static final String findAllQuery = "SELECT * FROM doctor";
    public static final String findBySpeciality = "SELECT * FROM doctor WHERE speciality = ?";
    public static final String findBySpecAndExp = "SELECT * FROM doctor WHERE speciality = ? AND experience = ?";
    public static final String findBySpecAndRatings = "SELECT * FROM doctor WHERE speciality=? AND ratings >= ?";
    public static final String findBySpecAndFees = "SELECT * FROM doctor WHERE speciality=? AND fees <= ?";
    public static final String findBySpecAndName = "SELECT * FROM doctor WHERE speciality=? AND doctor_name LIKE ?";
    public static final String findById = "SELECT * FROM doctor WHERE doctor_id=?";
}