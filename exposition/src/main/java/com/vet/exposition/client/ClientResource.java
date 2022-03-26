package com.vet.exposition.client;

import com.vet.dto.ClientDto;
import com.vet.facade.ManageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientResource {

    @Autowired
    private ManageClient manageClient;

    @GetMapping("/{id}")
    public ClientDto get(@PathVariable Long id){
        return manageClient.get(id);
    }

    @GetMapping
    public Set<ClientRepresentation> listClientsOrdered(){
        return manageClient.findAllOrdered().stream().map(ClientRepresentation::toRepresentation).collect(toSet());
    }

    @PostMapping
    public void create(@RequestBody ClientDto client){
        manageClient.create(client);
    }

    @PutMapping
    public void update(@RequestBody ClientDto client){
        manageClient.update(client);
    }

}
