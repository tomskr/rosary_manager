package pl.tomskr.rosary_manager.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@DynamicUpdate
@Table(name = "rosary_group")
public class RosaryGroup{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int groupNumber;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private List<Event> eventList = new ArrayList<>();
    @OneToMany(mappedBy = "groupRos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RosaryMember> rosaryMembers  = new ArrayList<>();


}

