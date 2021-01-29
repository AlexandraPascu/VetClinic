package com.vet.config;

import com.vet.repository.BaseRepositoryImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.vet"})
@EntityScan(basePackages = {"com.vet"})
@EnableJpaRepositories(
        basePackages = {"com.vet"},
        repositoryBaseClass = BaseRepositoryImpl.class
)
@EnableAutoConfiguration
public class PersistenceContextConfig {

}
