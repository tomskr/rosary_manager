package pl.tomskr.rosary_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HarmonogramController {
    @RequestMapping(value = "index/harmonogram")
    public String openHarmonogram(){
        return "harmonogram";
    }
}
