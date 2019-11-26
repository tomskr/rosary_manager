package pl.tomskr.rosary_manager.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.repository.RosaryGroupRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RosaryGroupServiceImplTest {

    RosaryGroupServiceImpl rosaryGroupService;

    @Mock
    RosaryGroupRepository rosaryGroupRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        rosaryGroupService = new RosaryGroupServiceImpl(rosaryGroupRepository);
    }

    @Test
    void getRosaryGroups() throws  Exception {
        RosaryGroup rosaryGroup = new RosaryGroup();
        ArrayList<RosaryGroup> rosaryGroupData = new ArrayList();

        rosaryGroupData.add(rosaryGroup);
        when(rosaryGroupRepository.findAll()).thenReturn(rosaryGroupData);

        List<RosaryGroup> rosaryGroupList = rosaryGroupService.getRosaryGroups();

        assertEquals(rosaryGroupList.size(),1);
        verify(rosaryGroupRepository, times(1)).findAll();
    }

//    @Test
//    void findById() {
//    }
//
//    @Test
//    void findByNr() {
//    }
//
//    @Test
//    void deleteById() {
//    }
//
//    @Test
//    void save() {
//    }
//
//    @Test
//    void saveAll() {
//    }
}