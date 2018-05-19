package com.vet.facade;

import com.vet.annotations.Facade;
import com.vet.dto.PatientDto;
import com.vet.entity.Client;
import com.vet.entity.Patient;
import com.vet.mapper.PatientMapper;
import com.vet.repository.ClientRepository;
import com.vet.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Facade
public class PatientFacade {

    @Autowired
    private PatientRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PatientMapper mapper;

    public PatientDto get(Long id) {
        return mapper.toDto(repository.findExactlyOne(id));
    }

    public void create(PatientDto dto) {
        Patient patient = mapper.toEntity(dto);
        validateUniqueness(patient);
        repository.save(patient);
    }

    public void update(PatientDto dto) {
        Patient existingPatient = repository.findExactlyOne(dto.id);
        Patient patientToBePersisted = mapper.toEntity(existingPatient, dto);
        validateUniqueness(patientToBePersisted);
    }

    private void validateUniqueness(Patient petToBePersisted) {
        Client owner = clientRepository.findExactlyOne(petToBePersisted.getOwner().getId());
        Optional<Patient> existingPetSameNameAndOwner = repository.findByNameAndOwner(petToBePersisted.getName(), owner);
        if (existingPetSameNameAndOwner.isPresent() && !isSamePet(petToBePersisted, existingPetSameNameAndOwner.get())) {
            throw new RuntimeException(
                String.format(
                    "Already exists a pet with name %s for owner %s",
                    petToBePersisted.getName(),
                    owner.getBusinessIdAndName()
                )
            );
        }
    }

    private boolean isSamePet(Patient petToBePersisted, Patient existingPetSameNameAndOwner) {
        return existingPetSameNameAndOwner.getId().equals(petToBePersisted.getId());
    }

}
