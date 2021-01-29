package com.vet.appointment;

import com.vet.client.Client;
import com.vet.DateTimeRange;
import com.vet.medicalstaff.Doctor;
import com.vet.patient.Patient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;

import static com.vet.appointment.AppointmentStatus.CANCELED;
import static com.vet.appointment.AppointmentStatus.COMPLETED;

@Entity
@Table(name = "APPOINTMENTS")
@Getter
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AppointmentGenerator")
    @SequenceGenerator(name = "AppointmentGenerator", sequenceName = "APPOINTMENT_SEQ", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;

    @Embedded
    private DateTimeRange timeRange;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "APPOINTMENT_TYPE")
    @Enumerated(EnumType.STRING)
    private AppointmentType appointmentType;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @Column(name = "COMMENT")
    private String comment;

    @Transient
    @Setter
    private boolean isConflicting;

    public void modifyDoctor(Doctor newDoctor) {
        this.doctor = newDoctor;
    }

    public void modifyTimeRange(DateTimeRange newTimeRange) {
        this.timeRange = newTimeRange;
    }

    public void cancel(){
        this.status = CANCELED;
    }

    public void complete(){
        this.status = COMPLETED;
    }

    public void modifyTitle(String newTitle) {
        this.title = newTitle;
    }

    public void modifyComment(String newComment) {
        this.comment = newComment;
    }

}
