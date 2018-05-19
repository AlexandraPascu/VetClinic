package com.vet.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

import static java.time.Duration.between;
import static java.time.temporal.ChronoUnit.MINUTES;

@Embeddable
@Getter
public class DateTimeRange {

    @Column(name = "START")
    private LocalDateTime start;

    @Column(name = "END")
    private LocalDateTime end;

    public DateTimeRange(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public DateTimeRange(LocalDateTime start, long durationInMinutes) {
        this.start = start;
        this.end = start.plusMinutes(durationInMinutes);
    }

    public void modifyStart(LocalDateTime newStart) {
        this.start = newStart;
    }

    public long getDurationInMinutes() {
        return between(start, end).get(MINUTES);
    }

    public boolean overlaps(DateTimeRange other){
        return this.start.isBefore(other.end) && this.end.isAfter(other.start);
    }
}
