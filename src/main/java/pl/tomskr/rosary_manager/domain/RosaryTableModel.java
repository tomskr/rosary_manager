package pl.tomskr.rosary_manager.domain;



import java.util.List;

public class RosaryTableModel {
    private String groupName;
    private List<RosaryMember> rosaryMemberList;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<RosaryMember> getRosaryMemberList() {
        return rosaryMemberList;
    }

    public void setRosaryMemberList(List<RosaryMember> rosaryMemberList) {
        this.rosaryMemberList = rosaryMemberList;
    }
}
