package pl.tomskr.rosary_manager.service;

import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.domain.RosaryMember;

public interface RosaryMemberService {
    RosaryMember findById(Long id);
    void deleteById(Long id);
    void save(RosaryMember rosaryMember);
}
