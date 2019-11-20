package pl.tomskr.rosary_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tomskr.rosary_manager.service.RosaryGroupService;

@Slf4j
@Controller
public class RosaryMemberController {
    private final RosaryGroupService rosaryGroupService;

    public RosaryMemberController(RosaryGroupService rosaryGroupService) {
        this.rosaryGroupService = rosaryGroupService;
    }

    @GetMapping
    @RequestMapping("/index/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("rosaryGroup", rosaryGroupService.findById(Long.valueOf(id)));
        return "members/show";
    }

}
