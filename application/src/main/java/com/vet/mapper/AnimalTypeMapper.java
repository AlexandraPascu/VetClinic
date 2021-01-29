package com.vet.mapper;

import com.vet.dto.AnimalTypeDto;
import com.vet.patient.AnimalType;
import org.springframework.stereotype.Service;

@Service
public class AnimalTypeMapper {

    public AnimalTypeDto toDto(AnimalType entity){
        AnimalTypeDto dto = new AnimalTypeDto();
        dto.name = entity.getName();
        return dto;
    }

    public AnimalType toEntity(AnimalTypeDto dto){
        AnimalType entity = new AnimalType();
        entity.setName(dto.name);
        return entity;
    }
    
}
