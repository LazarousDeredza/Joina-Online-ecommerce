package com.joina.joinaonline.Parking.adapters;

import java.util.Date;

public class TagRequests {

    String tenant;
    Integer amount;
    Date date;

    public TagRequests(String tenant, Integer amount, Date date) {
        this.tenant = tenant;
        this.amount = amount;
        this.date = date;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
