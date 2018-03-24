package com.vet.dto;

import java.time.LocalDate;
import java.util.Set;

public class ClientDto {

    public Long id;
    public String firstName;
    public String lastName;
    public String socialSecurityNo;
    public String address;
    public LocalDate joiningDate;
    public Set<PatientDto> pets;

}
