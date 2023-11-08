package com.example.datajpa.repository;

import com.example.datajpa.model.Product;

import java.util.Optional;

public interface ProductCustomRepository {
    Optional<Product> findProductByName(String name);
}
