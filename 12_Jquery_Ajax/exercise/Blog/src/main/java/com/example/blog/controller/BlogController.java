package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @GetMapping
    public ResponseEntity<Iterable<Blog>> allBlog(){
        return new ResponseEntity<>(iBlogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView showBlogPage()
    {
        return new ModelAndView("list", "blog", iBlogService.findAll());
    }

    @PostMapping
    public ResponseEntity<Blog> createSmartphone(@RequestBody Blog blog) {
        return new ResponseEntity<>(iBlogService.save(blog), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteSmartphone(@PathVariable Long id) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.remove(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("search")
    public ResponseEntity<Iterable<Blog>> searchBlogs(@RequestParam("name") String name){
        if (name.isEmpty() || name==""){

            return new ResponseEntity<>(iBlogService.findAll(),HttpStatus.OK);
        }
        List<Blog> blogs= iBlogService.findByName("%"+name+"%");
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
}
