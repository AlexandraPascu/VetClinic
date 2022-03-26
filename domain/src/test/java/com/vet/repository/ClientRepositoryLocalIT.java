package com.vet.repository;

import com.vet.BaseLocalIT;
import com.vet.client.Client;
import com.vet.client.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;

public class ClientRepositoryLocalIT extends BaseLocalIT{

    @Autowired
    private ClientRepository sut;

    @Test
    public void whenFindAllActiveByClient_thenReturnAllActiveAssociatedToClient(){
        Client firstClient = new Client();
        firstClient.setFirstName("John");
        firstClient.setLastName("Smith");
        firstClient.setJoiningDate(now());
        firstClient.setAddress("10, New York Avenue");
        firstClient.setSocialSecurityNo("12345");
        sut.saveAndFlush(firstClient);

        Client secondClient = new Client();
        secondClient.setFirstName("Johnny");
        secondClient.setLastName("Dupree");
        secondClient.setJoiningDate(now());
        secondClient.setAddress("34, Ottawa Avenue");
        secondClient.setSocialSecurityNo("55667788");
        sut.saveAndFlush(secondClient);

        Optional<Client> result = sut.findBySocialSecurityNo("12345");
        assertThat(result).isPresent();
        assertThat(result.get().getSocialSecurityNo()).isEqualToIgnoringCase("12345");
    }

}
