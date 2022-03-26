package com.vet.facade;

import com.vet.annotations.ApplicationService;
import com.vet.client.Client;
import com.vet.dto.ClientDto;
import com.vet.mapper.ClientMapper;
import com.vet.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@ApplicationService
public class ManageClient {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientMapper mapper;

    public Set<Client> findAllOrdered(){
        return repository.findAllByOrderByLastNameAscFirstNameAsc();
    }

    public ClientDto get(Long id){
        return mapper.toDto(repository.findByIdOrThrow(id));
    }

    public void create(ClientDto clientDto){
        Client client = mapper.toEntity(clientDto);
        validateUniqueness(client);
        repository.save(client);
    }

    public void update(ClientDto clientDto) {
        Client existingClient = repository.findByIdOrThrow(clientDto.id);
        Client client = mapper.toEntity(existingClient, clientDto);
        validateUniqueness(client);
    }

    private void validateUniqueness(Client client) {
        if(repository.findBySocialSecurityNo(client.getSocialSecurityNo()).isPresent()) {
            throw new RuntimeException(
                    String.format("Already exists a client with social security number ", client.getSocialSecurityNo())
            );
        }
    }


}
