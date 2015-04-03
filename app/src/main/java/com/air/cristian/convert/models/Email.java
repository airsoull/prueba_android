package com.air.cristian.convert.models;


public class Email {
    private String email;
    private String name;

    public Email(String email, String name) {
        this.setEmail(email);
        this.setName(name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
