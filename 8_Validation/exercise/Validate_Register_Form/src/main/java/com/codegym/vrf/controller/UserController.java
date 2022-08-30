package com.codegym.vrf.controller;

import com.codegym.vrf.dto.UserDTO;
import com.codegym.vrf.model.User;
import com.codegym.vrf.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public ModelAndView showRegisterForm()
    {
        return new ModelAndView("index", "user", new UserDTO());
    }

    @PostMapping("/create")
    public String checkValidation(@Valid @ModelAttribute("user")UserDTO userDTO, BindingResult bindingResult, Model model)
    {
        new UserDTO().validate(userDTO, bindingResult);
        if(bindingResult.hasFieldErrors())
        {
            model.addAttribute("user", userDTO);
            return "index";
        }
        else
        {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            iUserService.save(user);
            return "result";
        }
    }
}
