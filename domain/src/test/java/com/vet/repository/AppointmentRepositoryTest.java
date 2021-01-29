/*
package com.vet.repository;

import com.vet.BaseLocalIT;
import com.vet.appointment.Appointment;
import com.vet.client.Client;
import com.vet.config.PersistenceContextConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static com.vet.appointment.Appointment.builder;
import static com.vet.appointment.AppointmentStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BaseLocalIT.class, PersistenceContextConfig.class})
public class AppointmentRepositoryTest {

    @Autowired
    private AppointmentRepository sut;

    @Autowired
    private ClientRepository clientRepo;

    @Before
    public void init(){
        */
/*Client client = new Client();
        clientRepo.saveAndFlush(client);
        Client otherClient = new Client();
        clientRepo.saveAndFlush(otherClient);

        sut.saveAndFlush(builder().client(client).status(ACTIVE).build());
        sut.saveAndFlush(builder().client(client).status(CANCELED).build());
        sut.saveAndFlush(builder().client(client).status(COMPLETED).build());
        sut.saveAndFlush(builder().client(otherClient).status(ACTIVE).build());*//*

    }

    //@Test
    public void whenFindAllActiveByClient_thenReturnAllActiveAssociatedToClient(){
        Client client = new Client();
        clientRepo.saveAndFlush(client);
        Client otherClient = new Client();
        clientRepo.saveAndFlush(otherClient);

        Appointment activeAppointment = builder().client(client).status(ACTIVE).build();
        sut.saveAndFlush(activeAppointment);
        sut.saveAndFlush(builder().client(client).status(CANCELED).build());
        sut.saveAndFlush(builder().client(client).status(COMPLETED).build());
        sut.saveAndFlush(builder().client(otherClient).status(ACTIVE).build());

        Set<Appointment> allActiveByClient = sut.findAllActiveByClient(client);
        assertThat(allActiveByClient).hasSize(1);
        assertThat(allActiveByClient.iterator().next()).isEqualTo(activeAppointment);
    }

}
*/
