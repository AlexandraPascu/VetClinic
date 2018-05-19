package com.vet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "DOCTORS")
@NoArgsConstructor
public @Data class Doctor extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DoctorGenerator")
    @SequenceGenerator(name = "DoctorGenerator", sequenceName = "DOCTOR_SEQ", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Doctor(Long id) {
        this.id = id;
    }

}
