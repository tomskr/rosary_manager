package pl.tomskr.rosary_manager.domain;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date joiningDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date nameDay;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthDate;
    private String notes;

    public RosaryMember() {
    }

    public RosaryMember(Long groupId) {
        this.groupRos.setId(groupId);
    }
}
