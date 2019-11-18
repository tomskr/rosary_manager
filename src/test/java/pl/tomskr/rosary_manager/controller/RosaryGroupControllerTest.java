package pl.tomskr.rosary_manager.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.service.RosaryGroupService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class RosaryGroupControllerTest {

    @Mock
    RosaryGroupService rosaryGroupService;

    @Mock
    Model model;

    RosaryGroupController controller;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new RosaryGroupController(rosaryGroupService);
    }

    @Test
    public void TestMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }

    @Test
    public void getIndexPage() {


        //given
        List<RosaryGroup> rosaryGroups = new ArrayList<>();

        rosaryGroups.add(new RosaryGroup());

        RosaryGroup rosaryGroup = new RosaryGroup();
        rosaryGroup.setId(1L);

        rosaryGroups.add(rosaryGroup);

        when(rosaryGroupService.getRosaryGroups()).thenReturn(rosaryGroups);

        ArgumentCaptor<List<RosaryGroup>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        //when
        String viewName = controller.getIndexPage(model);

        //then
        assertEquals("index", viewName);
        verify(rosaryGroupService,times(1)).getRosaryGroups();
        verify(model,times(1)).addAttribute(eq("rosaryGroups"),argumentCaptor.capture());
        List<RosaryGroup> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }

}