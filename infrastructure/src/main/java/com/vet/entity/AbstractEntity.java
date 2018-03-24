package com.vet.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity implements Entity<Long> {

    /*@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VetGenerator")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/
}
