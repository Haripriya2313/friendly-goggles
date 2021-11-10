package com.workattech.splitwise.models;

public class User1 {
    private String id;
    private String name;
    private String email;
    private String pno;

    public User1(String id, String name, String email, String pno) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pno = pno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return pno;
    }

    public void setPhone(String pno) {
        this.pno = pno;
    }
}
