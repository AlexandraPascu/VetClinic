package com.vet;

import com.vet.config.PersistenceContextConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles({"H2"})
@ContextConfiguration(classes = {PersistenceContextConfig.class})
@Transactional
public class BaseLocalIT {

}


