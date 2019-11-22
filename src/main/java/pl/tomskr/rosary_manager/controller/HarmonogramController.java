package pl.tomskr.rosary_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tomskr.rosary_manager.service.RosaryGroupService;

@Controller
public class HarmonogramController {
    private final RosaryGroupService rosaryGroupService;

    public HarmonogramController(RosaryGroupService rosaryGroupService) {
        this.rosaryGroupService = rosaryGroupService;
    }

    @RequestMapping(value = "index/harmonogram")
    public String openHarmonogram(Model model){
        model.addAttribute("rosaryGroups", rosaryGroupService.getRosaryGroups());
        return "harmonogram";
    }
}
