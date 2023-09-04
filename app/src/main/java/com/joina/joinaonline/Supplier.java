package com.joina.joinaonline;

public class Supplier {
    String name;
    Double totalPrice;

    public Supplier(String name) {
        this.name = name;
    }

    public Supplier(String name, Double totalPrice) {
        this.name = name;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
