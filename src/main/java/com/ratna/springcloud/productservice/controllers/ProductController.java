package com.ratna.springcloud.productservice.controllers;

import com.ratna.springcloud.productservice.models.Coupon;
import com.ratna.springcloud.productservice.models.Product;
import com.ratna.springcloud.productservice.repos.ProductRepo;
import com.ratna.springcloud.productservice.restclient.CouponClient;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productapi")
public class ProductController {

    private final ProductRepo productRepo;
    private final CouponClient couponClient;

    public ProductController(ProductRepo productRepo, CouponClient couponClient) {
        this.productRepo = productRepo;
        this.couponClient = couponClient;
    }

    @PostMapping("/products")
    @Retry(name="product-api", fallbackMethod = "handleError")
    public Product create(@RequestBody Product product) {
        Coupon coupon = couponClient.getCoupon(product.getCode());
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepo.save(product);
    }

     public Product handleError(Product product, Exception exception) {
        System.out.println("Inside Handle Error!" + exception.getMessage());
        return product;
    }

}
