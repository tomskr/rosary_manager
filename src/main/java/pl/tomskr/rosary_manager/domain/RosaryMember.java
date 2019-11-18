package pl.tomskr.rosary_manager.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "rosary_member")
public class RosaryMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String firstName;
    private String lastName;
    private String role;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID", nullable = false)
    private RosaryGroup groupRos;

    private String phone;
    private String mobile;
    private String postCode;
    private String address;
    private Date joiningDate;
    private Date nameDay;
    private Date birthDate;
    private String notes;

}
