package pl.tomskr.rosary_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.service.RosaryGroupService;

import java.util.Set;

@Slf4j
@Controller
public class RosaryGroupController {
    private final RosaryGroupService rosaryGroupService;

    public RosaryGroupController(RosaryGroupService rosaryGroupService) {
        this.rosaryGroupService = rosaryGroupService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting index page");
        model.addAttribute("rosaryGroups", rosaryGroupService.getRosaryGroups());
        return "index";
    }
}
