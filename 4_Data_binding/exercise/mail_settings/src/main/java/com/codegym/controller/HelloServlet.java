package com.codegym.controller;

import com.codegym.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloServlet  {
    @GetMapping("/home")
    public ModelAndView setting(Setting setting)
    {
        return new ModelAndView("home", "setting", setting);
    }

    @PostMapping("/user")
    public ModelAndView user(@ModelAttribute("setting") Setting setting)
    {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("setting", setting);
        return modelAndView;
    }
}