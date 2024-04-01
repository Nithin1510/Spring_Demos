package org.doctorapp.model;

public enum Specialization {
    ORTHO("ORTHOPEDIATRICIAN"),
    PEDIA("PAEDIATRICIAN"),
    PHYSICIAN("GENERAL PHYSICIAN"),
    GYNAE("GYNAECOLOGIST"),
    NEURO("NEUROLOGY"),
    DERMA("DERMATOLOGIST");

    private final String speciality;

    Specialization(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }
}
