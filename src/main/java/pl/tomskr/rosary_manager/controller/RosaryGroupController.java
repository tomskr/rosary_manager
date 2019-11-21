package pl.tomskr.rosary_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.service.RosaryGroupService;

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


    @RequestMapping(value = "index/new", method = RequestMethod.GET)
    public String newGroup(Model model){
        model.addAttribute("rosaryGroup", new RosaryGroup());
        return "members/groupForm";
    }


    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String newGroupSubmit(@ModelAttribute RosaryGroup rosaryGroup) {
        rosaryGroupService.save(rosaryGroup);
        return "redirect:/";
    }


    @RequestMapping(value = "index/{id}/edit", method = RequestMethod.GET)
    public String EditById(@PathVariable String id,Model model){
        log.debug("Edited id " + id);
        model.addAttribute("rosaryGroup",rosaryGroupService.findById(Long.valueOf(id)));
        return "members/groupForm";
    }

    @RequestMapping(value = "index/{id}/delete", method = RequestMethod.GET)
    public String deleteById(@PathVariable String id){
        log.debug("Deleting id " + id);
        rosaryGroupService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
