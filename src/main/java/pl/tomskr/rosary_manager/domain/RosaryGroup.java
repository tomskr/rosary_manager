package pl.tomskr.rosary_manager.domain;

import javax.persistence.*;

@Entity
public class RosaryGroup{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer groupNumber;
    private String name;


//    @JoinColumn(name = "group_id")
//    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
//    private List<Event> eventList = new ArrayList<>();
//
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


}

