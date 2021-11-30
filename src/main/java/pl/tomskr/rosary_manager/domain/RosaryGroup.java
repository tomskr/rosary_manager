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
public class RosaryGroup{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int groupNumber;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private List<Event> eventList = new ArrayList<>();
    @OneToMany
    private List<RosaryMember> rosaryMembers  = new ArrayList<>();


}

