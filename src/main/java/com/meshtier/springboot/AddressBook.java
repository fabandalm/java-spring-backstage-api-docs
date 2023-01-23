package com.meshtier.springboot;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@RestController
public class AddressBook {

    ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<String, Contact>();

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable String id){

        return contacts.get(id);
    }

    @GetMapping("/")
    public List<Contact> getAllContacts(){

        return contacts.values().stream().toList();
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(), contact);
        return contact;
    }

}
