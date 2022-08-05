package com.example.db.repository;

import com.example.db.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
