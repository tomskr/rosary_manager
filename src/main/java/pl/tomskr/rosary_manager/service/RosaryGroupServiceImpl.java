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

    //Get list of all rosary group entries

    @Override
    public List<RosaryGroup> getRosaryGroups() {
        List<RosaryGroup> rosaryGroupList = new ArrayList<>();
        rosaryGroupRepository.findAll().iterator().forEachRemaining(rosaryGroupList::add);
        return rosaryGroupList;
    }

    //Find rosary group entry by id

    @Override
    public RosaryGroup findById(Long id) {
        Optional<RosaryGroup> optionalRosaryGroup = rosaryGroupRepository.findById(id);
            if(optionalRosaryGroup.isEmpty()){
                throw new RuntimeException("Group not found");
            }
        return optionalRosaryGroup.get();
    }

    //Find rosary group by group number

    @Override
    public RosaryGroup findByNr(int nr) {
//        List<RosaryGroup> rosaryGroupList = new ArrayList<>();
//        rosaryGroupRepository.findAll().iterator().forEachRemaining(rosaryGroupList::add);
//        for(RosaryGroup temp:rosaryGroupList){
//            if(temp.getGroupNumber()==nr){
//                return temp;
//            }
//        }
        //todo: fix it
        return null;
    }

    //delete rosary group entry by id

    @Override
    public void deleteById(Long id) {
        rosaryGroupRepository.deleteById(id);
    }

    //save rosary group entry

    @Override
    public void save(RosaryGroup rosaryGroup) {
        rosaryGroupRepository.save(rosaryGroup);
    }

    //save list of rosary group entry's

    @Override
    public void saveAll(List<RosaryGroup> rosaryGroupList) {
        rosaryGroupRepository.saveAll(rosaryGroupList);
    }
}
