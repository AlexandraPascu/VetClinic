package com.vet.repository;

import com.vet.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends BaseRepository<Client, Long> {

    public List<Client> findAllByOrderByLastNameAscFirstNameAsc();

    public List<Client> findAllByOrderByJoiningDateDesc();

}
