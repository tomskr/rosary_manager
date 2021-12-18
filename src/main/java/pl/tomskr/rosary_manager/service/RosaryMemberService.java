package pl.tomskr.rosary_manager.service;

import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.domain.RosaryMember;

import java.util.List;

public interface RosaryMemberService {
    RosaryMember findById(Long id);
    List<RosaryMember> sortMembers(List<RosaryMember> rosaryMemberList);
    void deleteById(Long id);
    void save(RosaryMember rosaryMember);
}
