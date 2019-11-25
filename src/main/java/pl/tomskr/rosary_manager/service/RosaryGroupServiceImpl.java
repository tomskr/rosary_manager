package pl.tomskr.rosary_manager.service;

import org.springframework.stereotype.Service;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.repository.RosaryGroupRepository;

import java.util.*;

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

    @Override
    public RosaryGroup findById(Long id) {
        Optional<RosaryGroup> optionalRosaryGroup = rosaryGroupRepository.findById(id);
            if(!optionalRosaryGroup.isPresent()){
                throw new RuntimeException("Group not found");
            }
        return optionalRosaryGroup.get();
    }

    @Override
    public RosaryGroup findByNr(int nr) {
        List<RosaryGroup> rosaryGroupList = rosaryGroupRepository.findAll();
        for(RosaryGroup temp:rosaryGroupList){
            if(temp.getGroupNumber()==nr){
                return temp;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        rosaryGroupRepository.deleteById(id);
    }

    @Override
    public void save(RosaryGroup rosaryGroup) {
        rosaryGroupRepository.save(rosaryGroup);
    }

    @Override
    public void saveAll(List<RosaryGroup> rosaryGroupList) {
        rosaryGroupRepository.saveAll(rosaryGroupList);
    }
}
