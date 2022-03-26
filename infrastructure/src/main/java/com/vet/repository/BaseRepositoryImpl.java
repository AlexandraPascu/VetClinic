package com.vet.repository;

import com.vet.entity.Entity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Optional;

public class BaseRepositoryImpl <T extends Entity<ID>, ID extends Serializable>
        extends SimpleJpaRepository<T, ID>  implements BaseRepository<T, ID> {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public T findByIdOrThrow(ID id) {
        Optional<T> entityOpt = findById(id);
        return entityOpt.orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("No %s with ID %s", getDomainClass().getSimpleName(), id.toString())
                )
        );
    }
}
