package com.vet.controller;

import com.vet.dto.PatientDto;
import com.vet.facade.PatientFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientFacade patientFacade;

    @GetMapping("/{id}")
    public PatientDto get(@PathVariable Long id){
        return patientFacade.get(id);
    }

    /*@GetMapping
    public Set<PatientDto> listPatientsOrdered(){
        return patientFacade.findAllOrdered();
    }*/

    @PostMapping
    public void create(@RequestBody PatientDto Patient){
        patientFacade.create(Patient);
    }

    @PutMapping
    public void update(@RequestBody PatientDto Patient){
        patientFacade.update(Patient);
    }
    
}
