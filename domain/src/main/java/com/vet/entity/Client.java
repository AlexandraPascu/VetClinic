package com.vet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;
import static java.lang.String.join;

@Entity
@Table(name = "CLIENTS")
@NoArgsConstructor
public @Data class Client extends AbstractEntity {

    public static final String PREFIX_BUSINESS_ID = "VC";

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
    //@Setter(AccessLevel.NONE)
    private Set<Patient> pets = new HashSet<>();

    public Client(Long id) {
        this.id = id;
    }

    public String getBusinessId(){
        return PREFIX_BUSINESS_ID + id;
    }

    public String getFullName(){
        return join(" ", firstName, lastName);
    }

    public String getBusinessIdAndName(){
        return format("%s (%s)", getBusinessId(), getFullName());
    }

    public void addPet(Patient pet){
        pet.setOwner(this);
        pets.add(pet);
    }

    public void removePet(Patient pet){
        pets.remove(pet);
    }
}
