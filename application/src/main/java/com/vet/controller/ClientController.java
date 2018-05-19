package com.vet.controller;

import com.vet.dto.ClientDto;
import com.vet.entity.Client;
import com.vet.facade.ClientFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientFacade clientFacade;

    @GetMapping("/{id}")
    public ClientDto get(@PathVariable Long id){
        return clientFacade.get(id);
    }

    @GetMapping
    public Set<ClientDto> listClientsOrdered(){
        return clientFacade.findAllOrdered();
    }

    @PostMapping
    public void create(@RequestBody ClientDto client){
        clientFacade.create(client);
    }

    @PutMapping
    public void update(@RequestBody ClientDto client){
        clientFacade.update(client);
    }

}
