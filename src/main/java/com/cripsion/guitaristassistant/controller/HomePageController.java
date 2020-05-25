package com.cripsion.guitaristassistant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomePageController {
    @RequestMapping("/homepage")
    public String homepage(){
        return "homepage";
    }
}
