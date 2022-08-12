package com.example.db.service.blog;

import com.example.db.model.Blog;
import com.example.db.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Iterable<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

    Optional<Blog> findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
