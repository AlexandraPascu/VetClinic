package com.vet.patient;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
@Table(name = "ANIMAL_TYPES")
public @Data class AnimalType {

    @Id
    @Column(name = "NAME")
    private String name;

}
