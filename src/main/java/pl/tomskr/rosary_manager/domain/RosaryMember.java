package pl.tomskr.rosary_manager.domain;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "rosary_member")
public class RosaryMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;
    private String firstName;
    private String lastName;
    private String preayerPledge;
    private String role;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID", nullable = false)
    private RosaryGroup groupRos;

    private String phone;
    private String mobile;
    private String postCode;
    private String address;
    private String joiningDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date nameDay;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthDate;
    private String notes;
    private int memberOrder;

    public RosaryMember() {
    }

    public RosaryMember(String firstName, String lastName, String preayerPledge, String role, RosaryGroup groupRos, String phone, String mobile, String postCode, String address, String joiningDate, Date nameDay, Date birthDate, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.preayerPledge = preayerPledge;
        this.role = role;
        this.groupRos = groupRos;
        this.phone = phone;
        this.mobile = mobile;
        this.postCode = postCode;
        this.address = address;
        this.joiningDate = joiningDate;
        this.nameDay = nameDay;
        this.birthDate = birthDate;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "RosaryMember{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", joiningDate=" + joiningDate +
                '}';
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPreayerPledge() {
        return preayerPledge;
    }

    public void setPreayerPledge(String preayerPledge) {
        this.preayerPledge = preayerPledge;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public RosaryGroup getGroupRos() {
        return groupRos;
    }

    public void setGroupRos(RosaryGroup groupRos) {
        this.groupRos = groupRos;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getNameDay() {
        return nameDay;
    }

    public void setNameDay(Date nameDay) {
        this.nameDay = nameDay;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getMemberOrder() {
        return memberOrder;
    }

    public void setMemberOrder(int memberOrder) {
        this.memberOrder = memberOrder;
    }
}
