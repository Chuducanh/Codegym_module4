package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Long id);

    List<Blog> findByName(String name);

    Blog save(Blog blog);

    void remove(Long id);
}
