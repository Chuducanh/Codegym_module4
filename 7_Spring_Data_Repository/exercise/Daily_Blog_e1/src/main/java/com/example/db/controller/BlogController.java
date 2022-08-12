package com.example.db.controller;

import com.example.db.model.Blog;
import com.example.db.model.Category;
import com.example.db.service.blog.IBlogService;
import com.example.db.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("category")
    public Iterable<Category> categories()
    {
        return iCategoryService.findAll();
    }


    @GetMapping("/blog")
    public ModelAndView listBlogs(@RequestParam("search") Optional<String> search, @PageableDefault(value = 5) Pageable pageable){
        Page<Blog> blog;
        ModelAndView modelAndView = new ModelAndView("/blog/home");
        if(search.isPresent()){
            blog = iBlogService.findAllByNameContaining(search.get(), pageable);
            modelAndView.addObject("search",search.get());
        } else {
            blog = iBlogService.findAll(pageable);
        }
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Blog> blog = iBlogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public String deleteBlog(@PathVariable Long id) {
        iBlogService.remove(id);
        return "redirect:/blog";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView viewSong(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        Optional<Blog> blog = iBlogService.findById(id);
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }
}
