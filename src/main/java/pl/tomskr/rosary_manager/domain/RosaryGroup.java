package pl.tomskr.rosary_manager.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class RosaryGroup{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer groupNumber;
    private String name;


    @JoinColumn(name = "group_id")
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Event> eventSet = new HashSet<>();

//    @OneToMany
//    private List<RosaryMember> rosaryMembers  = new ArrayList<>();


    public RosaryGroup() {
    }

    public RosaryGroup(Integer groupNumber, String name) {
        this.groupNumber = groupNumber;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Event> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<Event> eventSet) {
        this.eventSet = eventSet;
    }
}

