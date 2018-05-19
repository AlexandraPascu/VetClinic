package com.vet.entity;

import lombok.Getter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;

import static com.vet.entity.AppointmentStatus.CANCELED;
import static com.vet.entity.AppointmentStatus.COMPLETED;

@Entity
@Table(name = "APPOINTMENTS")
@Getter
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

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "STATUS")
    @Enumerated
    private AppointmentStatus status;

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
