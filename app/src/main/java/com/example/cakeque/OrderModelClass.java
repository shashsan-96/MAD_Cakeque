package com.example.cakeque;

public class OrderModelClass {
    Integer orderId;
    String name;
    String address;
    String requirements;
    String budget;
    String dDate;

    //Constructor
    public OrderModelClass(String name, String address, String requirements, String budget, String dDate) {
        this.name = name;
        this.address = address;
        this.requirements = requirements;
        this.budget = budget;
        this.dDate = dDate;
    }

    public OrderModelClass(Integer orderId, String name, String address, String requirements, String budget, String dDate) {
        this.orderId = orderId;
        this.name = name;
        this.address = address;
        this.requirements = requirements;
        this.budget = budget;
        this.dDate = dDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getdDate() {
        return dDate;
    }

    public void setdDate(String dDate) {
        this.dDate = dDate;
    }
}