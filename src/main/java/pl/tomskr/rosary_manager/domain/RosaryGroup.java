package pl.tomskr.rosary_manager.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "rosary_group")
public class RosaryGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long bookOrder;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private List<Event> eventList = new ArrayList<>();
    @OneToMany(mappedBy = "groupRos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RosaryMember> rosaryMembers  = new ArrayList<>();

}
