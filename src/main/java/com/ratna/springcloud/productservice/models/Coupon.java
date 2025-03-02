package com.ratna.springcloud.productservice.models;

import java.math.BigDecimal;

public class Coupon {
    private Long id;
    private String code;
    private BigDecimal discount;
    private String expDate;

    public Coupon() {
    }

    public Coupon(String code, BigDecimal discount, String expDate) {
        this.code = code;
        this.discount = discount;
        this.expDate = expDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
