package pl.tomskr.rosary_manager.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate eventStart;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate eventStop;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID", nullable = false)
    private RosaryGroup groupRos;

    public Event() {
    }

    public Event(LocalDate eventStart, LocalDate eventStop) {
        this.eventStart = eventStart;
        this.eventStop = eventStop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEventStart() {
        return eventStart;
    }

    public void setEventStart(LocalDate eventStart) {
        this.eventStart = eventStart;
    }

    public LocalDate getEventStop() {
        return eventStop;
    }

    public void setEventStop(LocalDate eventStop) {
        this.eventStop = eventStop;
    }

    public RosaryGroup getGroupRos() {
        return groupRos;
    }

    public void setGroupRos(RosaryGroup groupRos) {
        this.groupRos = groupRos;
    }
}
