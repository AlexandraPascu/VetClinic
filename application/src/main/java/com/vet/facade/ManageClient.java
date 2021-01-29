package com.vet.facade;

import com.vet.annotations.ApplicationService;
import com.vet.dto.ClientDto;
import com.vet.client.Client;
import com.vet.mapper.ClientMapper;
import com.vet.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@ApplicationService
public class ManageClient {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientMapper mapper;

    public Set<ClientDto> findAllOrdered(){
        return repository.findAllByOrderByLastNameAscFirstNameAsc()
                .stream()
                .map(mapper::toDto)
                .collect(toSet());
    }

    public ClientDto get(Long id){
        return mapper.toDto(repository.findExactlyOne(id));
    }

    public void create(ClientDto clientDto){
        Client client = mapper.toEntity(clientDto);
        validateUniqueness(client);
        repository.save(client);
    }

    public void update(ClientDto clientDto) {
        Client existingClient = repository.findExactlyOne(clientDto.id);
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
