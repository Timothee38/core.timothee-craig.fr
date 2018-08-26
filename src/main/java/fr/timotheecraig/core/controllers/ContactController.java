package fr.timotheecraig.core.controllers;

import fr.timotheecraig.core.exceptions.RessourceNotFoundException;
import fr.timotheecraig.core.models.Contact;
import fr.timotheecraig.core.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/contact")
    public List<Contact> getAllProjects() {
        return contactService.getContacts();
    }

    @PostMapping("/contact")
    public Contact createProjects(@Valid @RequestBody Contact contact) { return  contactService.addContact(contact); }

    @PutMapping("/contact/{id}")
    public Contact updateProjects(@PathVariable(value = "id") Integer id, @Valid @RequestBody Contact contactDetails) {
        Contact contact = contactService.findContactById(id).orElseThrow(() -> new RessourceNotFoundException("Contacts", "id", id));
        return contactService.updateContact(contact, contactDetails);
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<?> deleteProjects(@PathVariable(value = "id") Integer id) {
        Contact contact = contactService.findContactById(id).orElseThrow(() -> new RessourceNotFoundException("Contacts", "id", id));
        contactService.deleteContact(contact);
        return ResponseEntity.ok().build();
    }

}
