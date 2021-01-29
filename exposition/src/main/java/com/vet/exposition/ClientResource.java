package com.vet.exposition;

import com.vet.dto.ClientDto;
import com.vet.facade.ManageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
    public Set<ClientDto> listClientsOrdered(){
        return manageClient.findAllOrdered();
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
