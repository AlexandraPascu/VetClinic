package com.vet.exposition.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vet.client.Client;
import com.vet.dto.PatientDto;

import java.time.LocalDate;
import java.util.Set;

public class ClientRepresentation {

    @JsonProperty public Long id;
    @JsonProperty public String firstName;
    @JsonProperty public String lastName;
    @JsonProperty public String socialSecurityNo;
    @JsonProperty public String address;
    @JsonProperty public LocalDate joiningDate;
    @JsonProperty public Set<PatientDto> pets;
    @JsonProperty public Integer version;

    public static ClientRepresentation toRepresentation(Client entity){
        ClientRepresentation representation = new ClientRepresentation();
        representation.id = entity.getId();
        representation.address = entity.getAddress();
        representation.firstName = entity.getFirstName();
        representation.lastName = entity.getLastName();
        representation.joiningDate = entity.getJoiningDate();
        representation.socialSecurityNo = entity.getSocialSecurityNo();
        //representation.pets = patientMapper.toDtos(entity.getPets());
        representation.version = entity.getVersion();
        return representation;
    }

}
