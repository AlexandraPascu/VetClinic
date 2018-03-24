package com.vet.repository;

import com.vet.entity.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends BaseRepository<Doctor, Long> {

}
