package com.vet.mapper;

import com.vet.dto.ClientDto;
import com.vet.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    @Autowired
    private PatientMapper patientMapper;

    public ClientDto toDto(Client entity){
        ClientDto dto = new ClientDto();
        dto.id = entity.getId();
        dto.address = entity.getAddress();
        dto.firstName = entity.getFirstName();
        dto.lastName = entity.getLastName();
        dto.joiningDate = entity.getJoiningDate();
        dto.socialSecurityNo = entity.getSocialSecurityNo();
        //dto.pets = patientMapper.toDtos(entity.getPets());
        return dto;
    }

    public Client toEntity(ClientDto dto){
        Client entity = new Client();
        return toEntity(entity, dto);
    }

    public Client toEntity(Client entity, ClientDto dto) {
        entity.setAddress(dto.address);
        entity.setFirstName(dto.firstName);
        entity.setLastName(dto.lastName);
        entity.setJoiningDate(dto.joiningDate);
        entity.setSocialSecurityNo(dto.socialSecurityNo);
        //entity.setPets(patientMapper.toEntities(dto.pets));
        return entity;
    }

}
