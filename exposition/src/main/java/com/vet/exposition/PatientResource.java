package com.vet.exposition;

import com.vet.dto.PatientDto;
import com.vet.facade.ManagePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientResource {

    @Autowired
    private ManagePatient managePatient;

    @GetMapping("/{id}")
    public PatientDto get(@PathVariable Long id){
        return managePatient.get(id);
    }

    /*@GetMapping
    public Set<PatientDto> listPatientsOrdered(){
        return managePatient.findAllOrdered();
    }*/

    @PostMapping
    public void create(@RequestBody PatientDto Patient){
        managePatient.create(Patient);
    }

    @PutMapping
    public void update(@RequestBody PatientDto Patient){
        managePatient.update(Patient);
    }
    
}
