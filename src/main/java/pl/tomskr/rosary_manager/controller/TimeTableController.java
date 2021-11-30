package pl.tomskr.rosary_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tomskr.rosary_manager.service.RosaryGroupService;

@Controller
public class TimeTableController {
    private final RosaryGroupService rosaryGroupService;

    public TimeTableController(RosaryGroupService rosaryGroupService) {
        this.rosaryGroupService = rosaryGroupService;
    }

    @RequestMapping(value = "index/timetable")
    public String openTimeTable(Model model){
        model.addAttribute("rosaryGroups", rosaryGroupService.getRosaryGroups());
        return "timetable";
    }
}
