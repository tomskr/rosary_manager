package pl.tomskr.rosary_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.service.RosaryGroupService;


import java.util.Comparator;
import java.util.List;

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
        List<RosaryGroup> rosaryGroupList = rosaryGroupService.getRosaryGroups();
        rosaryGroupList.sort(Comparator.comparing(RosaryGroup::getGroupNumber));
        model.addAttribute("rosaryGroups", rosaryGroupList);
        return "index";
    }

    @RequestMapping({"index/sort"})
    public String sortRosaryGroup(){
    return  "redirect:/";
    }


    @RequestMapping(value = "index/new", method = RequestMethod.GET)
    public String newGroup(Model model){
        model.addAttribute("rosaryGroup", new RosaryGroup());
        return "members/groupFormNew";
    }


    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String newGroupSubmit(@ModelAttribute RosaryGroup rosaryGroup) {
        List<RosaryGroup> tempList = rosaryGroupService.getRosaryGroups();
        log.debug("new id: "+ ((long)tempList.size() + 1L));
        rosaryGroup.setId((long)tempList.size() + 1L);
        rosaryGroup.setGroupNumber(tempList.size() + 1);
        rosaryGroupService.save(rosaryGroup);
        return "redirect:/";
    }

    @RequestMapping(value = "/index/{nr}/edit", method = RequestMethod.POST)
    public String editGroupSubmit(@ModelAttribute RosaryGroup rosaryGroup,@PathVariable String nr,@RequestParam("opOption") String option) {
        if(option.equals("switch")) {
            RosaryGroup temp = rosaryGroupService.findByNr(rosaryGroup.getGroupNumber());
            temp.setGroupNumber(Integer.valueOf(nr));
            rosaryGroupService.save(temp);
            rosaryGroupService.save(rosaryGroup);
            log.debug("switch");
        }else{
            RosaryGroup temp = null;
            if(Integer.valueOf(nr) > rosaryGroup.getGroupNumber()) {
                for (int x = Integer.valueOf(nr); x >= rosaryGroup.getGroupNumber(); x--) {
                    temp = rosaryGroupService.findByNr(x);
                    temp.setGroupNumber(x + 1);
                    rosaryGroupService.save(temp);
                }
            }else{
                for (int x = rosaryGroup.getGroupNumber(); x > Integer.valueOf(nr); x--) {
                    temp = rosaryGroupService.findByNr(x);
                    temp.setGroupNumber(x - 1);
                    rosaryGroupService.save(temp);
                }
            }
            rosaryGroupService.save(rosaryGroup);
            log.debug("insert");
        }
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
