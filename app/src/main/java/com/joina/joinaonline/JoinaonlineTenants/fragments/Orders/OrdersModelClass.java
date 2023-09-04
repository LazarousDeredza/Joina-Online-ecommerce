package com.joina.joinaonline.JoinaonlineTenants.fragments.Orders;

public class OrdersModelClass {
    String orderNumber;
    String userName;
    String totalPrice;
    String status;
    Integer id;

    public OrdersModelClass(String orderNumber, String userName, String totalPrice, String status, Integer id) {
        this.orderNumber = orderNumber;
        this.userName = userName;
        this.totalPrice = totalPrice;
        this.status = status;
        this.id = id;
    }

    public OrdersModelClass(String orderNumber, String userName, String totalPrice, String status) {
        this.orderNumber = orderNumber;
        this.userName = userName;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public Integer getId() {
        return id;
    }
}
