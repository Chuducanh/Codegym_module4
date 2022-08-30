package com.codegym.pc.service;

import com.codegym.pc.model.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
