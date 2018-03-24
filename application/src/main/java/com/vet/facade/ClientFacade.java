package com.vet.facade;

import com.vet.annotations.Facade;
import com.vet.entity.Client;
import com.vet.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Facade
public class ClientFacade {

    @Autowired
    private ClientRepository clientRepo;

    public Client get(Long id){
        return clientRepo.findExactlyOne(id);
    }

    public List<Client> findAllOrdered(){
        return clientRepo.findAllByOrderByLastNameAscFirstNameAsc();
    }

}
