package pl.tomskr.rosary_manager.service;

import org.springframework.stereotype.Service;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.repository.RosaryGroupRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RosaryGroupServiceImpl implements RosaryGroupService {
    private final RosaryGroupRepository rosaryGroupRepository;

    public RosaryGroupServiceImpl(RosaryGroupRepository rosaryGroupRepository) {
        this.rosaryGroupRepository = rosaryGroupRepository;
    }

    @Override
    public List<RosaryGroup> getRosaryGroups() {
        List<RosaryGroup> rosaryGroupList = new ArrayList<>();
        rosaryGroupRepository.findAll().iterator().forEachRemaining(rosaryGroupList::add);
        return rosaryGroupList;
    }
}
