package com.vet.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity implements Entity<Long> {

    @Version
    @Column(name = "version")
    private Integer version;

    public AbstractEntity(Integer version) {
        this.version = version;
    }

    protected AbstractEntity() {
        // used by JPA
    }

    public abstract Long getId();

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
