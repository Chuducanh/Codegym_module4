package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class dictionary{

    @GetMapping("/translate")
    public String translate()
    {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String english, Model model)
    {
        String[] engDic = {"one","two","three","four"};
        String[] vietDic = {"1","2","3","4"};
        model.addAttribute("english", english);
        for(int i=0; i<engDic.length; i++)
        {
            if(engDic[i].equals(english))
            {
                model.addAttribute("viet", vietDic[i]);
                break;
            }
        }
        return "index";
    }

}