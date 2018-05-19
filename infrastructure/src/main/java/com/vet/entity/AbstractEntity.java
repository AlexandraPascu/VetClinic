package com.vet.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Entity<Long> {

    public abstract Long getId();

}
