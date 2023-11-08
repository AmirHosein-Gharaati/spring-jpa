package com.example.datajpa.repository;

import com.example.datajpa.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {
    @Override
    public Optional<Product> findProductByName(String name) {
        return Optional.empty();
    }
}
