package com.vet.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "ANIMAL_TYPES")
public @Data class AnimalType {

    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AnimalTypeGenerator")
    @SequenceGenerator(name = "AnimalTypeGenerator", sequenceName = "ANIMAL_TYPE_SEQ", initialValue = 1, allocationSize = 1)
    private Long id;*/

    @Id
    @Column(name = "NAME")
    private String name;

}
