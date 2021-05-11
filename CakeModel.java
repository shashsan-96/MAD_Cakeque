package com.example.cakeque;

public class CakeModel {

    Integer id;
    String userid;
    String orderid;
    String proposition;
    String cakecost;
    String delivercost;
    String contacts;


    public CakeModel( String userid, String orderid, String proposition, String cakecost, String delivercost, String contacts) {
        this.userid = userid;
        this.orderid = orderid;
        this.proposition = proposition;
        this.cakecost = cakecost;
        this.delivercost = delivercost;
        this.contacts = contacts;
    }

    public CakeModel(Integer id, String userid, String orderid, String proposition, String cakecost, String delivercost, String contacts) {
        this.id = id;
        this.userid = userid;
        this.orderid = orderid;
        this.proposition = proposition;
        this.cakecost = cakecost;
        this.delivercost = delivercost;
        this.contacts = contacts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    public String getCakecost() {
        return cakecost;
    }

    public void setCakecost(String cakecost) {
        this.cakecost = cakecost;
    }

    public String getDelivercost() {
        return delivercost;
    }

    public void setDelivercost(String delivercost) {
        this.delivercost = delivercost;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}

