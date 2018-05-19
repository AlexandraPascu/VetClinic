package com.vet.dto;

import com.vet.entity.Patient;

public class PatientDto {

    public Long id;
    public String name;
    public AnimalTypeDto animalType;
    public Patient.Gender gender;
    public ClientDto owner;
    public DoctorDto preferredDoctor;
    public byte[] picture;
    public boolean isDeleted = false;

}
