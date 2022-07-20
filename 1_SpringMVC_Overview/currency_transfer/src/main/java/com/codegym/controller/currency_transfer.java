package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@Controller
public class currency_transfer {
    @GetMapping("/transfer")
    public String transfer()
    {
        return "index";
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam String dollar, Model model)
    {
        Double viet = 23000 * Double.parseDouble(dollar);
        model.addAttribute("dollar", dollar);
        model.addAttribute("viet", viet.toString());
        return "index";
    }
}