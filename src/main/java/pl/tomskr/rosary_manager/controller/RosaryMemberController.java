package pl.tomskr.rosary_manager.controller;


import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.domain.RosaryMember;
import pl.tomskr.rosary_manager.service.RosaryGroupService;
import pl.tomskr.rosary_manager.service.RosaryMemberService;

import java.util.Comparator;

@Slf4j
@Controller
public class RosaryMemberController {
    private final RosaryGroupService rosaryGroupService;
    private final RosaryMemberService rosaryMemberService;


    public RosaryMemberController(RosaryGroupService rosaryGroupService, RosaryMemberService rosaryMemberService) {
        this.rosaryGroupService = rosaryGroupService;
        this.rosaryMemberService = rosaryMemberService;
    }

    @RequestMapping( value = "/index/{id}/show", method = RequestMethod.GET)
    public String showById(@PathVariable String id, Model model){
        RosaryGroup rosaryGroup = rosaryGroupService.findById(Long.valueOf(id));
        rosaryGroup.getRosaryMembers();
//        int count =0;
//        for(RosaryMember temp:rosaryGroup.getRosaryMembers()){
//           count++;
//           temp.setMemberOrder(count);
//        }
        model.addAttribute("rosaryGroup", rosaryGroup);
        return "members/show";
    }
//
//    @RequestMapping( value = "/index/{id}/show", method = RequestMethod.POST)
//    public String addMember(@ModelAttribute RosaryMember rosaryMember,@PathVariable String id){
//        rosaryMemberService.save(rosaryMember);
//        return "redirect:/index/{id}/show";
//    }
//
//    @RequestMapping(value = "/index/{id}/show/new", method = RequestMethod.GET)
//    public  String addMember(@PathVariable String id, Model model){
//        log.debug("rosaryMember intro");
//        RosaryMember rosaryMember = new RosaryMember();
//        model.addAttribute("rosaryMember", rosaryMember);
//        rosaryMember.setGroupRos(rosaryGroupService.findById(Long.valueOf(id)));
//        return "members/memberForm";
//    }
//    @RequestMapping(value = "/index/{id}/show/{memberId}/edit", method = RequestMethod.GET)
//    public  String editMember(@PathVariable String id,@PathVariable String memberId, Model model){
//        model.addAttribute("rosaryMember",rosaryMemberService.findById(Long.valueOf(memberId)));
//        return "members/memberForm";
//    }
//
//    @RequestMapping(value = "/index/{id}/show/{memberId}/delete", method = RequestMethod.GET)
//    public  String deleteMember(@PathVariable String id,@PathVariable String memberId, Model model) {
//        rosaryMemberService.deleteById(Long.valueOf(memberId));
//        return "redirect:/index/{id}/show";
//    }


}
