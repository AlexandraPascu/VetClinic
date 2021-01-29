package com.vet.medicalstaff;

import com.vet.entity.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DOCTOR")
@NoArgsConstructor
@Data
public class Doctor extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DoctorGenerator")
    @SequenceGenerator(name = "DoctorGenerator", sequenceName = "DOCTOR_SEQ", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Doctor(Long id) {
        this.id = id;
    }

}
