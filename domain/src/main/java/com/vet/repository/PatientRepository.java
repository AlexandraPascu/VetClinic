package com.vet.repository;

import com.vet.entity.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends BaseRepository<Patient, Long> {

}
