package com.example.contacts.repository;

import com.example.contacts.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
     private List<Contact> contacts = new ArrayList<>();
    public List<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}
