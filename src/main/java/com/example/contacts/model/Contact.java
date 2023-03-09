package com.example.contacts.model;

public class Contact {

    private String name;
    private String email;
    private String place;

    public Contact(String name, String email, String place) {
        this.name = name;
        this.email = email;
        this.place = place;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
