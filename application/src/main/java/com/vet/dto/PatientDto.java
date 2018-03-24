package com.vet.dto;

import com.vet.entity.AnimalType;
import com.vet.entity.Patient;

public class PatientDto {

    public Long id;
    public String name;
    public AnimalType animalType;
    public Patient.Gender gender;
    public ClientDto owner;
    public DoctorDto preferredDoctor;
    public byte[] picture;

}
