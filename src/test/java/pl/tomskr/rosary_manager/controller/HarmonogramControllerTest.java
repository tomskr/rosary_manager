package pl.tomskr.rosary_manager.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.service.RosaryGroupService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class HarmonogramControllerTest {

    @Mock
    RosaryGroupService rosaryGroupService;

    @Mock
    Model model;

    @Captor
    private ArgumentCaptor<List<RosaryGroup>> captor;

    HarmonogramController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new HarmonogramController(rosaryGroupService);
    }

//    @Test
//    public void TestMockMVC() throws Exception {
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//        mockMvc.perform(get("index/harmonogram"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("harmonogram"));
//
//    }

    @Test
    void openHarmonogram() {
        //given
        List<RosaryGroup> rosaryGroups = new ArrayList<>();

        rosaryGroups.add(new RosaryGroup());

        when(rosaryGroupService.getRosaryGroups()).thenReturn(rosaryGroups);

        //when
        String viewName = controller.openHarmonogram(model);

        //then

        assertEquals("harmonogram", viewName);
        verify(rosaryGroupService,times(1)).getRosaryGroups();
        verify(model,times(1)).addAttribute(eq("rosaryGroups"),captor.capture());
        List<RosaryGroup> setInController = captor.getValue();
        assertEquals(1, setInController.size());
    }
}