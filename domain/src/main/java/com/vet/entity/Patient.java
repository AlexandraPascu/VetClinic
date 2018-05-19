package com.vet.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "PATIENTS")
public @Data class Patient extends AbstractEntity {

    public enum Gender {
        MALE,
        FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PatientGenerator")
    @SequenceGenerator(name = "PatientGenerator", sequenceName = "PATIENT_SEQ", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ANIMAL_TYPE")
    private AnimalType animalType;

    @Column(name = "GENDER")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Client owner;

    @OneToOne
    @JoinColumn(name = "PREFERRED_DOCTOR_ID")
    private Doctor preferredDoctor;

    @Lob
    @Column(name = "PICTURE", columnDefinition = "mediumblob")
    private byte[] picture;

    @Column(name = "IS_DELETED")
    private boolean isDeleted = false;

}
