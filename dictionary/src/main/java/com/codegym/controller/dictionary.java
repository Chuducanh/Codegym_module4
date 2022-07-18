package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class dictionary{

    @GetMapping("/translate")
    public String translate()
    {

    }
}