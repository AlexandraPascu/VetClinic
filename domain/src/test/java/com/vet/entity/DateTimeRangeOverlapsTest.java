package com.vet.entity;

import com.vet.DateTimeRange;
import org.junit.Test;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

public class DateTimeRangeOverlapsTest {

    @Test
    public void whenOneRangeContainsAnother_thenTheyOverlap(){
        DateTimeRange aRange = new DateTimeRange(now().minusMinutes(5), 60);
        DateTimeRange anotherRange = new DateTimeRange(now(), 30);
        assertThat(aRange.overlaps(anotherRange));
    }

    @Test
    public void whenEndRangeIsBetweenStartAndEndAnotherRange_thenTheyOverlap(){
        DateTimeRange aRange = new DateTimeRange(now().minusMinutes(30), 60);
        DateTimeRange anotherRange = new DateTimeRange(now(), 60);
        assertThat(aRange.overlaps(anotherRange));
    }

    @Test
    public void whenStartRangeIsBetweenStartAndEndAnotherRange_thenTheyOverlap(){
        DateTimeRange aRange = new DateTimeRange(now().minusMinutes(30), 60);
        DateTimeRange anotherRange = new DateTimeRange(now().minusMinutes(60), 60);
        assertThat(aRange.overlaps(anotherRange));
    }

    @Test
    public void whenEndFirstRangeIsBeforeStartSecondRange_thenTheyDoNotOverlap(){
        DateTimeRange aRange = new DateTimeRange(now().minusMinutes(30), 30);
        DateTimeRange anotherRange = new DateTimeRange(now().plusMinutes(30), 30);
        assertThat(!aRange.overlaps(anotherRange));
    }

    @Test
    public void whenEndFirstRangeIsImmediatelyBeforeStartSecondRange_thenTheyDoNotOverlap(){
        DateTimeRange aRange = new DateTimeRange(now().minusMinutes(30), 30);
        DateTimeRange anotherRange = new DateTimeRange(now(), 30);
        assertThat(!aRange.overlaps(anotherRange));
    }

}
