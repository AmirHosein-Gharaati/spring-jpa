package com.example.datajpa.repository;

import com.example.datajpa.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductCustomRepository {
    Optional<Product> findByName(String name);
    Page<Product> findUsingPaging(Pageable pageable);
    List<Product> findAllByPriceEquals(int price);

    @Query("SELECT p FROM Product p WHERE p.price > :threshold")
    List<Product> findProductsAbovePrice(@Param("threshold") int threshold);

    boolean existsByName(String name);

}
