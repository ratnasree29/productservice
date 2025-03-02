package com.ratna.springcloud.productservice.repos;

import com.ratna.springcloud.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
