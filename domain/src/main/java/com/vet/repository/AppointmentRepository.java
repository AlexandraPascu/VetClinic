package com.vet.repository;

import com.vet.appointment.Appointment;
import com.vet.client.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface AppointmentRepository extends BaseRepository<Appointment, Long> {

    Set<Appointment> findAllByClient(Client client);

    @Query("SELECT a FROM Appointment a WHERE a.client = :client AND a.status = 'ACTIVE'")
    Set<Appointment> findAllActiveByClient(@Param(value = "client") Client client);

}
