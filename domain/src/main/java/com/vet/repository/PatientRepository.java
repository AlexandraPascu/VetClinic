package com.vet.repository;

import com.vet.entity.Client;
import com.vet.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.security.acl.Owner;
import java.util.Optional;

@Repository
public interface PatientRepository extends BaseRepository<Patient, Long> {

    public Optional<Patient> findByNameAndOwner(String name, Client owner);

}
