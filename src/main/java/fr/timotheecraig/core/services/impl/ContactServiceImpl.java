package fr.timotheecraig.core.services.impl;

import fr.timotheecraig.core.models.Contact;
import fr.timotheecraig.core.repositories.ContactRepository;
import fr.timotheecraig.core.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    /** Getters and Setters **/
    public ContactRepository getContactRepository() {
        return contactRepository;
    }

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    /** Methods **/
    public List<Contact> getContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Contact contactToUpdate, Contact contactDetails) {
        contactToUpdate.setEnTitle(contactDetails.getEnTitle());
        contactToUpdate.setFrTitle(contactDetails.getFrTitle());
        contactToUpdate.setLink(contactDetails.getLink());
        return contactRepository.save(contactToUpdate);
    }

    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    public Optional<Contact> findContactById(Integer id) {
        return contactRepository.findById(id);
    }

}
