package com.Entity;

public class Customer {
    private int cid;
    private String fname;
    private String lname;
    private long mobileno;
    private String email;
    private String address;

    public Customer() {
        this.cid = cid;
        this.fname = fname;
        this.lname = lname;
        this.mobileno = mobileno;
        this.email = email;
        this.address = address;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "cid=" + cid + ", fname='" + fname + '\'' + ", lname='" + lname + '\'' + ", mobileno=" + mobileno + ", email='" + email + '\'' + ", address='" + address + '\'' + '}';
    }
}
