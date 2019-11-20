package pl.tomskr.rosary_manager.service;

import pl.tomskr.rosary_manager.domain.RosaryGroup;

import java.util.List;
import java.util.Set;

public interface RosaryGroupService {
    List<RosaryGroup> getRosaryGroups();
    RosaryGroup findById(Long id);
    void deleteById(Long id);
    void save(RosaryGroup rosaryGroup);
}
