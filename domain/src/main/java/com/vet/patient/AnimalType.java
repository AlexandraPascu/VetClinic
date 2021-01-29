package com.vet.patient;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "ANIMAL_TYPES")
public @Data class AnimalType {

    @Id
    @Column(name = "NAME")
    private String name;

}
