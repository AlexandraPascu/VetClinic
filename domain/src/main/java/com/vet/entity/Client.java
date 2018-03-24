package com.vet.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "CLIENTS")
public @Data class Client extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ClientGenerator")
    @SequenceGenerator(name = "ClientGenerator", sequenceName = "CLIENT_SEQ", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SOCIAL_SECURITY_NO")
    private String socialSecurityNo;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "JOINING_DATE")
    private LocalDate joiningDate;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Patient> pets;

}
