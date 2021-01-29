package com.vet.mapper;

import com.vet.dto.DoctorDto;
import com.vet.medicalstaff.Doctor;
import org.springframework.stereotype.Service;

@Service
public class DoctorMapper {

    public DoctorDto toDto(Doctor entity){
        DoctorDto dto = new DoctorDto();
        dto.id = entity.getId();
        dto.name = entity.getName();
        return dto;
    }

    public Doctor toEntity(DoctorDto dto){
        Doctor entity = new Doctor();
        entity.setId(dto.id);
        entity.setName(dto.name);
        return entity;
    }
}
