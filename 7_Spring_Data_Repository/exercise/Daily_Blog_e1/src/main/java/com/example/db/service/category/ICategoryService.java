package com.example.db.service.category;

import com.example.db.model.Category;

public interface ICategoryService {
    Iterable<Category> findAll();
}
