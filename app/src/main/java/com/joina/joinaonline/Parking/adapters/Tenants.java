package com.joina.joinaonline.Parking.adapters;

public class Tenants {

    String name;
    Integer floor;
    Integer employees;

    public Tenants(String name, Integer floor, Integer employees) {
        this.name = name;
        this.floor = floor;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }
}
