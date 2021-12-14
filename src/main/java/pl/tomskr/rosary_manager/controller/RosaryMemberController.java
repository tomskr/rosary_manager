package pl.tomskr.rosary_manager.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.domain.RosaryMember;
import pl.tomskr.rosary_manager.domain.RosarySecret;
import pl.tomskr.rosary_manager.domain.Secret;
import pl.tomskr.rosary_manager.service.RosaryGroupService;
import pl.tomskr.rosary_manager.service.RosaryMemberService;
import pl.tomskr.rosary_manager.service.RosarySecretService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Controller
public class RosaryMemberController {
    private final RosaryGroupService rosaryGroupService;
    private final RosaryMemberService rosaryMemberService;
    private final RosarySecretService rosarySecretService;


    public RosaryMemberController(RosaryGroupService rosaryGroupService, RosaryMemberService rosaryMemberService, RosarySecretService rosarySecretService) {
        this.rosaryGroupService = rosaryGroupService;
        this.rosaryMemberService = rosaryMemberService;
        this.rosarySecretService = rosarySecretService;
    }

    @RequestMapping( value = "/index/{id}/show", method = RequestMethod.GET)
    public String showById(@PathVariable String id, Model model){
        RosaryGroup rosaryGroup = rosaryGroupService.findById(Long.valueOf(id));
        String groupName = rosaryGroup.getName();
        List<RosaryMember> rosaryMemberList = rosaryGroup.getRosaryMembers();
        List<RosarySecret> rosarySecretsLIst = new ArrayList<RosarySecret>();
        List<RosarySecret> SecretsLIst = new ArrayList<RosarySecret>();
        rosaryMemberList.stream().forEach(rosaryMember -> {
            SecretsLIst.add(new RosarySecret(rosaryMember.getFirstName(),rosaryMember.getLastName(),rosarySecretService.secretList(rosaryMember.getPreayerPledge())));});

        Comparator<RosaryMember> compareByName = (RosaryMember rm1, RosaryMember rm2) -> rm1.getFirstName().compareTo(rm2.getFirstName());

        rosaryMemberList.sort(Comparator.comparing(RosaryMember::getLastName, Comparator.nullsLast(Comparator.naturalOrder())));
        rosarySecretsLIst = rosarySecretService.secretOrder(SecretsLIst);

        int counter = 1;
        for (RosaryMember member: rosaryMemberList)
        {
            member.setMemberOrder(counter);
            counter++;
        }

        model.addAttribute("groupName", groupName);
        model.addAttribute("rosaryMemberList", rosaryMemberList);
        model.addAttribute("rosarySecretsLIst", rosarySecretsLIst);
        return "members/show";
    }

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
