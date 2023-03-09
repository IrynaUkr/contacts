package com.example.contacts.controller;

import com.example.contacts.model.Contact;
import com.example.contacts.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final ContactRepository repository;

    @Autowired
    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return repository.findAll();
    }

    @PostMapping()
    public Contact addContact(@RequestBody Contact contact) {
        return repository.save(contact);
    }

    @PutMapping("/{email}")
    public Contact updateContact(@PathVariable String email, @RequestBody Contact contact) {
        Contact persistedContact = repository.findByEmail(email);
        if (contact.getName() != null) {
            persistedContact.setName(contact.getName());
        }
        if (contact.getPlace() != null) {
            persistedContact.setPlace(contact.getPlace());
        }
        return repository.save(persistedContact);
    }

    @GetMapping("/{email}")
    public Contact getContactByEmail(@PathVariable String email) {
        return repository.findByEmail(email);
    }

    @DeleteMapping("/{email}")
    public void deleteContact(@PathVariable String email) {
        log.info("delete by email was called");
        repository.delete(repository.findByEmail(email));
    }

}
