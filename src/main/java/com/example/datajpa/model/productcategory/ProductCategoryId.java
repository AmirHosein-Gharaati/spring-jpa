package com.example.datajpa.model.productcategory;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProductCategoryId implements Serializable {

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "category_id")
    private Long categoryId;
}
