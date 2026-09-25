package com.learning.customers.models;

import com.github.javafaker.Faker;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.Instant;
import java.time.ZoneId;

@Entity
public class CustomerOrderEntity {

    @Id
    private long orderid;
    private String productName;
    private String productDescription;
    private String productPrice;
    private String orderDate;
    private String orderStatus;
    private String orderType;

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public CustomerOrderEntity() {
        Faker faker = new Faker();
        Instant now = Instant.now();
        this.orderid = now.toEpochMilli() + faker.number().randomNumber();
        this.productName = faker.commerce().productName();
        this.productDescription = faker.lorem().sentence();
        this.productPrice = faker.commerce().price();
        this.orderDate = String.valueOf(now.atZone(ZoneId.systemDefault()).toLocalDate());
        this.orderStatus = faker.options().option("Processing", "Shipped", "Delivered", "Cancelled");
        this.orderType = faker.options().option("standard-order", "rush-order", "back-order", "return-order", "exchange-order", "subscription-order", "dropship-order");
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderType='" + orderType + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productName='" + productName + '\'' +
                ", orderId=" + orderid +
                '}';
    }
}
