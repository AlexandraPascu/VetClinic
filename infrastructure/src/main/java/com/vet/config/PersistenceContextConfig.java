package com.vet.config;

import com.vet.repository.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.vet"},
        repositoryBaseClass = BaseRepositoryImpl.class
)
public class PersistenceContextConfig {

}
