package com.ratna.springcloud.productservice.restclient;

import com.ratna.springcloud.productservice.models.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("GATEWAY-SERVICE")
public interface CouponClient {
    @GetMapping("/couponapi/coupons/code/{code}")
    Coupon getCoupon(@PathVariable("code") String code);
}
