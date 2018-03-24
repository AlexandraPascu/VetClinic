package com.vet.controller;

import com.vet.entity.Client;
import com.vet.facade.ClientFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientFacade clientFacade;

    @GetMapping("/{id}")
    public Client get(@PathVariable Long id){
        return clientFacade.get(id);
    }

    @GetMapping
    public List<Client> listClientsOrdered(){
        return clientFacade.findAllOrdered();
    }

}
