package pl.tomskr.rosary_manager.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class RosaryGroup{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer groupNumber;
    private String name;
    private Boolean active;


    @JoinColumn(name = "group_id")
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Event> eventList = new ArrayList<>();

    @JoinColumn(name = "group_id")
    @OneToMany
    private List<RosaryMember> rosaryMembers = new ArrayList<>();



    public RosaryGroup() {
    }

    public RosaryGroup(Integer groupNumber, String name, Boolean active) {
        this.groupNumber = groupNumber;
        this.name = name;
        this.active = active;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<RosaryMember> getRosaryMembers() {
        return rosaryMembers;
    }

    public void setRosaryMembers(List<RosaryMember> rosaryMembers) {
        this.rosaryMembers = rosaryMembers;
    }
}

