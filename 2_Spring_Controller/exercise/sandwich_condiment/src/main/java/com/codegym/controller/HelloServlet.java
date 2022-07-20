package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloServlet{
    @GetMapping("/index")
    public String hello()
    {
        return "index";
    }

    @PostMapping("/index")
    public ModelAndView getCondiment(@RequestParam String condiment){
        return new ModelAndView("index", "res", condiment);
    }
}