package com.codegym.pms.service;

import com.codegym.pms.model.Product;

import java.util.Optional;

public interface IProductService<T> {
    Iterable<Product> findAll();

    Optional<Product> findById(int id);

    void save(Product product);

    void delete(int id);
}
