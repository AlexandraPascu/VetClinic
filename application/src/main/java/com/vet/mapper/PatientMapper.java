package com.vet.mapper;

import com.vet.dto.PatientDto;
import com.vet.entity.Client;
import com.vet.entity.Doctor;
import com.vet.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class PatientMapper {

    @Autowired
    private AnimalTypeMapper animalTypeMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    public PatientDto toDto(Patient entity){
        PatientDto dto = new PatientDto();
        dto.id = entity.getId();
        dto.animalType = animalTypeMapper.toDto(entity.getAnimalType());
        dto.gender = entity.getGender();
        dto.name = entity.getName();
        dto.picture = entity.getPicture();
        dto.preferredDoctor = doctorMapper.toDto(entity.getPreferredDoctor());
        return dto;
    }

    public Patient toEntity(PatientDto dto){
        Patient entity = new Patient();
        return toEntity(entity, dto);
    }

    public Patient toEntity(Patient entity, PatientDto dto){
        entity.setAnimalType(animalTypeMapper.toEntity(dto.animalType));
        entity.setDeleted(dto.isDeleted);
        entity.setGender(dto.gender);
        entity.setName(dto.name);
        entity.setPicture(dto.picture);
        if(dto.preferredDoctor != null && dto.preferredDoctor.id != null) {
            entity.setPreferredDoctor(new Doctor(dto.preferredDoctor.id));
        }
        entity.setOwner(new Client(dto.owner.id));
        return entity;
    }

    public Set<PatientDto> toDtos(Set<Patient> pets) {
        return pets.stream().map(this::toDto).collect(toSet());
    }

    public Set<Patient> toEntities(Set<PatientDto> pets) {
        return pets.stream().map(this::toEntity).collect(toSet());
    }


}
