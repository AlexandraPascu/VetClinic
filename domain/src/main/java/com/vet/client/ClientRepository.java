package com.vet.client;

import com.vet.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ClientRepository extends BaseRepository<Client, Long> {

    Set<Client> findAllByOrderByLastNameAscFirstNameAsc();

    Set<Client> findAllByOrderByJoiningDateDesc();

    Optional<Client> findBySocialSecurityNo(String socialSecurityNo);

}
