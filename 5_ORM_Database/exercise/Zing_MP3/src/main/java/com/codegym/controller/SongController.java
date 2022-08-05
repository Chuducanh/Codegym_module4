package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import com.codegym.service.SongServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mp3")
public class SongController {
    private ISongService iSongService = new SongServiceImpl();

    @GetMapping("")
    public String home(Model model)
    {
        List<Song> song = iSongService.findAll();
        model.addAttribute("song", song);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String save(Song song)
    {
        iSongService.save(song);
        return "redirect:/mp3";
    }

    @GetMapping("/{id}/delete")
    public String deleteSong(@PathVariable int id){
        iSongService.delete(id);
        return "redirect:/mp3";
    }

    @GetMapping("/{id}/view")
    public ModelAndView viewSong(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("view");
        Song song = iSongService.findById(id);
        modelAndView.addObject("song", song);
        return modelAndView;
    }
}
