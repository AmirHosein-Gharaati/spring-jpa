package com.example.datajpa.service;

import com.example.datajpa.model.Product;
import com.example.datajpa.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void findByName(String name) {
        Optional<Product> productOptional = productRepository.findByName(name);
        if(productOptional.isPresent()) {
            Product product = productOptional.get();
            // TODO
        }
    }

    public Page<Product> findByPageable() {
        int pageNumber = 1;
        int pageSize = 10;
        String fileNameToSortBy = "...";

        Pageable pageable = PageRequest.of(
                pageNumber,
                pageSize,
                Sort.by(Sort.Direction.ASC, fileNameToSortBy)
        );
        return productRepository.findUsingPaging(pageable);
    }

    public List<Product> findAllByPrice(int price) {
        return productRepository.findAllByPriceEquals(price);
    }

    public List<Product> findProductsAbovePrice(int price) {
        return productRepository.findProductsAbovePrice(price);
    }

    public void customMethod() {
        Optional<Product> productOptional = productRepository.findProductByName("Test name");
        // TODO
    }

}
