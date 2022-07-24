package com.codegym.controller;

import com.codegym.model.HealthForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloServlet {
    @GetMapping("/health")
    public ModelAndView form()
    {
        return new ModelAndView("home", "form", new HealthForm());
    }

    @PostMapping("/user")
    public ModelAndView user(@ModelAttribute("form") HealthForm healthForm)
    {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("form", healthForm);
        return modelAndView;
    }
}