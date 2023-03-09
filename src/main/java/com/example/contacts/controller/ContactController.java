package com.example.contacts.controller;

import com.example.contacts.model.Contact;
import com.example.contacts.repository.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {
    ContactRepository repository = new ContactRepository();

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return repository.getContacts();
    }

    @PostMapping()
    public boolean addContact(@RequestBody Contact contact) {
        List<Contact> contacts = repository.getContacts();
        boolean isContactAdded = contacts.add(contact);
        repository.setContacts(contacts);
        return isContactAdded;
    }

    @PutMapping("/{email}")
    public Contact updateContact(@PathVariable String email, @RequestBody Contact contact) {
        List<Contact> contacts = repository.getContacts();
        Contact persistedContact = getContact(email, contacts);
        persistedContact.setName(contact.getName());
        persistedContact.setPlace(contact.getPlace());
        return persistedContact;
    }

    @GetMapping("/{email}")
    public Contact getContactByEmail(@PathVariable String email) {
        return getContact(email, repository.getContacts());
    }

    @DeleteMapping
    public boolean deleteContact(@PathVariable String email) {
        List<Contact> contacts = repository.getContacts();
        Contact contact = getContact(email, contacts);
        return contacts.remove(contact);
    }

    private static Contact getContact(String email, List<Contact> contacts) {
        return contacts
                .stream()
                .filter(cont -> cont.getEmail().equals(email))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
