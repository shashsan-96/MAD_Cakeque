package com.example.cakeque;

public class ProfileModelClass {

    Integer id;
    String fname;
    String lname;
    String userid;
    String qualifications;
    String contact;
    String location;

    public ProfileModelClass(String fname, String lname, String userid, String qualifications, String contact, String location) {
        this.fname = fname;
        this.lname = lname;
        this.userid = userid;
        this.qualifications = qualifications;
        this.contact = contact;
        this.location = location;
    }

    public ProfileModelClass(Integer id, String fname, String lname, String userid, String qualifications, String contact, String location) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.userid = userid;
        this.qualifications = qualifications;
        this.contact = contact;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

