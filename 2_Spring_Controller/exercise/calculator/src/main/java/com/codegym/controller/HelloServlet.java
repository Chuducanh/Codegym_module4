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
    public ModelAndView getFunction(@RequestParam String val1, @RequestParam String val2, @RequestParam String function){
        int result;
        switch(function)
        {
            case "+":
                result = Integer.parseInt(val1) + Integer.parseInt(val2);
                break;
            case "-":
                result = Integer.parseInt(val1) - Integer.parseInt(val2);
                break;
            case "*":
                result = Integer.parseInt(val1) * Integer.parseInt(val2);
                break;
            case "/":
                result = Integer.parseInt(val1) / Integer.parseInt(val2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + function);
        }
        return new ModelAndView("index", "result", result);
    }
}