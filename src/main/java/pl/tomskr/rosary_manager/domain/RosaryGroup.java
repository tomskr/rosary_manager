package pl.tomskr.rosary_manager.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "rosary_group")
public class RosaryGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<RosaryMember> rosaryMembers  = new HashSet<>();
}
