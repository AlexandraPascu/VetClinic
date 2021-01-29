package com.vet.repository;

import com.vet.client.Client;
import com.vet.patient.Patient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends BaseRepository<Patient, Long> {

    public Optional<Patient> findByNameAndOwner(String name, Client owner);

}
